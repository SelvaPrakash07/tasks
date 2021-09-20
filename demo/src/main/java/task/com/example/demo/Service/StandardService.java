package task.com.example.demo.Service;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.Constants;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import task.com.example.demo.BaseResponse.PageResponse;
import task.com.example.demo.Constants.MasterConstants;
import task.com.example.demo.DTO.MediumDto;
import task.com.example.demo.DTO.StandardDto;
import task.com.example.demo.DTO.SubjectDto;
import task.com.example.demo.Model.*;
import task.com.example.demo.Repository.*;
import task.com.example.demo.Serviceinterface.StandardInterface;

import javax.transaction.Transactional;
import java.sql.Timestamp;
import java.util.LinkedList;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
@Transactional
public class StandardService implements StandardInterface {

    @Autowired
    private StandardMediumRepo standardMediumRepo;

    @Autowired
    private StandardRepo standardRepo;

    @Autowired
    private MediumRepo mediumRepo;

    @Autowired
    private SubjectRepo subjectRepo;

    @Autowired
    private StandardSubjectRepo standardSubjectRepo;

    @Autowired
    private SectionRepo sectionRepo;

    @Override
    public Standard savestandard(StandardDto standardDto) {
        try {
            ModelMapper modelMapper = new ModelMapper();
            Standard standard = modelMapper.map(standardDto, Standard.class);
            standard.setCreatedAt(new Timestamp(new java.util.Date().getTime()));
            standard.setUpdatedAt(new Timestamp(new java.util.Date().getTime()));
            standard.setIsActive(0);
            standard.setIsDeleted(0);
            Optional<Section> section = sectionRepo.findById(standardDto.getSectionId());
            if (section.isPresent()) {
                standard.setSectionid(section.get());
            }
            standard = standardRepo.save(standard);
            savestandardMedium(standardDto.getMediumDtoList(), standard);
            savestandardsubject(standardDto.getSubjectDtoList(), standard);
            return standard;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
    @Override
    public PageResponse<Standard> getByname(Integer pageNo, Integer pageSize, String sortBy, String name) {
            Pageable paging = PageRequest.of(pageNo, pageSize, Sort.by(Sort.Direction.DESC, sortBy));
            Page<Standard> standardPage = standardRepo.searchAllByNameLike("%" + name + "%",paging);
            PageResponse pageResponse=new PageResponse();
            pageResponse.setHasNext(standardPage.hasNext());
            pageResponse.setHasPrevious(standardPage.hasPrevious());
            pageResponse.setTotalRecordCount(standardPage.getTotalPages());
            pageResponse.setData(standardPage);
            pageResponse.setStatusCode(MasterConstants.SUCCESS_CODE);
           pageResponse.setStatusMessage(MasterConstants.SUCCESS_MESSAGE);
       return pageResponse;
        }

    private void savestandardMedium(List<MediumDto> mediumDtoList, Standard standard) {
        try {
            List<StandardMedium> standardMedium = new LinkedList<>();
            if (Objects.nonNull(mediumDtoList) && mediumDtoList.size() > 0) {
                mediumDtoList.stream().forEachOrdered(mediums -> {
                    Medium medium1 = mediumRepo.findById(mediums.getId())
                            .orElseThrow(() -> new RuntimeException("id is not here"));
                    StandardMedium standardMedium1 = new StandardMedium();
                    standardMedium1.setStandard(standard);
                    standardMedium1.setMedium1(medium1);
                    standardMedium.add(standardMedium1);
                });
                standardMediumRepo.saveAll(standardMedium);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    private void savestandardsubject(List<SubjectDto> subjectDtoList, Standard standard) {
        try {
            List<StandardSubject> standardSubject = new LinkedList<>();
            if (Objects.nonNull(subjectDtoList) && subjectDtoList.size() > 0) {
                subjectDtoList.stream().forEachOrdered(subj -> {
                    Subject subject1 = subjectRepo.findById(subj.getId())
                            .orElseThrow(() -> new RuntimeException("id is not here"));
                    StandardSubject standardSubject1 = new StandardSubject();
                    standardSubject1.setStandard(standard);
                    standardSubject1.setSubject1(subject1);
                    standardSubject.add(standardSubject1);
                });
                standardSubjectRepo.saveAll(standardSubject);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    @Override
    public Optional<Standard> IsDeletedstandard(StandardDto standardDto) {
        Optional<Standard> standard = standardRepo.findById(standardDto.getId());
        if (standard.isPresent())
        {standard.get().setIsDeleted(1);
        }
        else
        {throw new RuntimeException(MasterConstants.ERROR_MESSAGE);
        }
        standardRepo.save(standard.get());
        return standard;
    }

    @Override
        public Optional<Standard> UpdatestandardById(StandardDto standardDto) {
        Optional<Standard> standard = standardRepo.findById(standardDto.getId());
        if (standard.isPresent())
        {standard.get().setName(standardDto.getName());
            standard.get().setCode(standardDto.getCode());
        }
        else
        {throw new RuntimeException(MasterConstants.ERROR_MESSAGE);
        }
        standardRepo.save(standard.get());
        return standard;
    }
}


