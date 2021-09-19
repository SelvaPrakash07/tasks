package task.com.example.demo.Service;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;

import task.com.example.demo.BaseResponse.ApiResponse;
import task.com.example.demo.BaseResponse.BaseResponse;
import task.com.example.demo.BaseResponse.PageResponse;
import task.com.example.demo.DTO.*;
import task.com.example.demo.Model.*;
import task.com.example.demo.Repository.*;

import java.sql.Timestamp;
import java.util.*;


@org.springframework.stereotype.Service
public class ServiceImpl implements Service {
    @Autowired
    private MediumRepo mediumRepo;

    @Autowired
    private SectionRepo sectionRepo;

    @Autowired
    private StaffRepo staffRepo;

    @Autowired
    private StandardRepo standardRepo;

    @Autowired
    private SubjectRepo subjectRepo;

    @Autowired
    private StandardMediumRepo standardMediumRepo;

    @Autowired
    private SubjectStaffRepo subjectStaffRepo;

    @Autowired
    private StandardSubjectRepo standardSubjectRepo;

    @Override
    public BaseResponse savemedium(MediumDto mediumDto) {
        BaseResponse baseResponse = new BaseResponse();
        ModelMapper modelMapper = new ModelMapper();
        Medium medium = modelMapper.map(mediumDto, Medium.class);
        mediumRepo.save(medium);
        baseResponse.setStatusCode("200");
        baseResponse.setStatusMsg("success");
        baseResponse.setData(medium);
        return baseResponse;
    }

    @Override
    public BaseResponse getAllMedium() {
        BaseResponse baseResponse = new BaseResponse();
        List<Medium> mediumList = mediumRepo.findAll();
        baseResponse.setStatusCode("200");
        baseResponse.setStatusMsg("success");
        baseResponse.setData(mediumList);
        return baseResponse;
    }

    @Override
    public BaseResponse getMediumById(int id) {
        BaseResponse baseResponse = new BaseResponse();
        Medium medium = mediumRepo.findById(id).orElse(null);
        baseResponse.setStatusCode("200");
        baseResponse.setStatusMsg("success");
        baseResponse.setData(medium);
        return baseResponse;
    }

    @Override
    public BaseResponse updatemedium(MediumDto mediumDto) {
        BaseResponse baseResponse = new BaseResponse();
        Medium medium = mediumRepo.findById(mediumDto.getId()).orElse(null);
        medium.setId(mediumDto.getId());
        medium.setMedium(mediumDto.getMedium());
        medium.setCreatedAt(new Timestamp(new java.util.Date().getTime()));
        medium.setUpdatedAt(new Timestamp(new java.util.Date().getTime()));
        medium.setIsActive(0);
        medium.setIsDeleted(0);
        mediumRepo.save(medium);
        baseResponse.setStatusCode("200");
        baseResponse.setStatusMsg("success");
        baseResponse.setData(medium);
        return baseResponse;
    }

    @Override
    public BaseResponse IsActivemedium(MediumDto mediumDto) {
        BaseResponse baseResponse = new BaseResponse();
        Medium medium = mediumRepo.findById(mediumDto.getId()).orElse(null);
        medium.setId(mediumDto.getId());
        medium.setIsActive(1);
        mediumRepo.save(medium);
        baseResponse.setStatusCode("200");
        baseResponse.setStatusMsg("success");
        baseResponse.setData(medium);
        return baseResponse;
    }

    @Override
    public BaseResponse IsDeletedmedium(MediumDto mediumDto) {
        BaseResponse baseResponse = new BaseResponse();
        Medium medium = mediumRepo.findById(mediumDto.getId()).orElse(null);
        medium.setId(mediumDto.getId());
        medium.setIsDeleted(1);
        mediumRepo.save(medium);
        baseResponse.setStatusCode("200");
        baseResponse.setStatusMsg("success");
        baseResponse.setData(medium);
        return baseResponse;
    }

    @Override
    public BaseResponse saveSection(SectionDto sectionDto) {
        BaseResponse baseResponse = new BaseResponse();
        ModelMapper modelMapper = new ModelMapper();
        Section section = modelMapper.map(sectionDto, Section.class);
        sectionRepo.save(section);
        baseResponse.setStatusCode("200");
        baseResponse.setStatusMsg("success");
        baseResponse.setData(section);
        return baseResponse;
    }

    @Override
    public BaseResponse getAllSection() {
        BaseResponse baseResponse = new BaseResponse();
        List<Section> sectionList = sectionRepo.findAll();
        baseResponse.setStatusCode("200");
        baseResponse.setStatusMsg("success");
        baseResponse.setData(sectionList);
        return baseResponse;
    }

    @Override
    public BaseResponse getSectionById(int id) {
        BaseResponse baseResponse = new BaseResponse();
        Section section = sectionRepo.findById(id).orElse(null);
        baseResponse.setStatusCode("200");
        baseResponse.setStatusMsg("success");
        baseResponse.setData(section);
        return baseResponse;
    }

    @Override
    public BaseResponse updatesection(SectionDto sectionDto) {
        BaseResponse baseResponse = new BaseResponse();
        Section section = sectionRepo.findById(sectionDto.getId()).orElse(null);
        section.setId(sectionDto.getId());
        section.setSectionName(sectionDto.getSectionName());
        section.setCreatedAt(new Timestamp(new java.util.Date().getTime()));
        section.setUpdatedAt(new Timestamp(new java.util.Date().getTime()));
        section.setIsActive(0);
        section.setIsDeleted(0);
        sectionRepo.save(section);
        baseResponse.setStatusCode("200");
        baseResponse.setStatusMsg("success");
        baseResponse.setData(section);
        return baseResponse;
    }

    @Override
    public BaseResponse IsActivesection(SectionDto sectionDto) {
        BaseResponse baseResponse = new BaseResponse();
        Section section = sectionRepo.findById(sectionDto.getId()).orElse(null);
        section.setId(sectionDto.getId());
        section.setIsActive(1);
        sectionRepo.save(section);
        baseResponse.setStatusCode("200");
        baseResponse.setStatusMsg("success");
        baseResponse.setData(section);
        return baseResponse;
    }

    @Override
    public BaseResponse IsDeletedSection(SectionDto sectionDto) {
        BaseResponse baseResponse = new BaseResponse();
        Section section = sectionRepo.findById(sectionDto.getId()).orElse(null);
        section.setId(sectionDto.getId());
        section.setIsDeleted(1);
        sectionRepo.save(section);
        baseResponse.setStatusCode("200");
        baseResponse.setStatusMsg("success");
        baseResponse.setData(section);
        return baseResponse;
    }

    @Override
    public BaseResponse savestaff(StaffDto staffDto) {
        BaseResponse baseResponse = new BaseResponse();
        ModelMapper modelMapper = new ModelMapper();
        Staff staff = modelMapper.map(staffDto, Staff.class);
        staffRepo.save(staff);
        baseResponse.setStatusCode("200");
        baseResponse.setStatusMsg("success");
        baseResponse.setData(staff);
        return baseResponse;
    }

    @Override
    public BaseResponse getAllStaff() {
        BaseResponse baseResponse = new BaseResponse();
        List<Staff> staffList = staffRepo.findAll();
        baseResponse.setStatusCode("200");
        baseResponse.setStatusMsg("success");
        baseResponse.setData(staffList);
        return baseResponse;
    }

    @Override
    public BaseResponse getStaffById(int id) {
        BaseResponse baseResponse = new BaseResponse();
        Staff staff = staffRepo.findById(id).orElse(null);
        baseResponse.setStatusCode("200");
        baseResponse.setStatusMsg("success");
        baseResponse.setData(staff);
        return baseResponse;
    }

    @Override
    public BaseResponse updatestaff(StaffDto staffDto) {
        BaseResponse baseResponse = new BaseResponse();
        Staff staff = staffRepo.findById(staffDto.getId()).orElse(null);
        staff.setId(staffDto.getId());
        staff.setStaffName(staffDto.getStaffName());
        staff.setCreatedAt(new Timestamp(new java.util.Date().getTime()));
        staff.setUpdatedAt(new Timestamp(new java.util.Date().getTime()));
        staff.setIsActive(0);
        staff.setIsDeleted(0);
        staffRepo.save(staff);
        baseResponse.setStatusCode("200");
        baseResponse.setStatusMsg("success");
        baseResponse.setData(staff);
        return baseResponse;
    }

    @Override
    public BaseResponse IsActiveStaff(StaffDto staffDto) {
        BaseResponse baseResponse = new BaseResponse();
        Staff staff = staffRepo.findById(staffDto.getId()).orElse(null);
        staff.setId(staffDto.getId());
        staff.setIsActive(1);
        staffRepo.save(staff);
        baseResponse.setStatusCode("200");
        baseResponse.setStatusMsg("success");
        baseResponse.setData(staff);
        return baseResponse;
    }

    @Override
    public BaseResponse IsDeletedStaff(StaffDto staffDto) {
        BaseResponse baseResponse = new BaseResponse();
        Staff staff = staffRepo.findById(staffDto.getId()).orElse(null);
        staff.setId(staffDto.getId());
        staff.setIsDeleted(1);
        staffRepo.save(staff);
        baseResponse.setStatusCode("200");
        baseResponse.setStatusMsg("success");
        baseResponse.setData(staff);
        return baseResponse;
    }

    @Override
    public BaseResponse savestandard(StandardDto standardDto) {
        BaseResponse baseResponse = new BaseResponse();
        ModelMapper modelMapper = new ModelMapper();
        Standard standard = modelMapper.map(standardDto, Standard.class);
        standardRepo.save(standard);
        baseResponse.setStatusCode("200");
        baseResponse.setStatusMsg("success");
        baseResponse.setData(standard);
        return baseResponse;
    }

    @Override
    public BaseResponse getAllstandard() {
        BaseResponse baseResponse = new BaseResponse();
        List<Standard> standardList = standardRepo.findAll();
        baseResponse.setStatusCode("200");
        baseResponse.setStatusMsg("success");
        baseResponse.setData(standardList);
        return baseResponse;
    }

    @Override
    public BaseResponse getStandardById(int id) {
        BaseResponse baseResponse = new BaseResponse();
        Standard standard = standardRepo.findById(id).orElse(null);
        baseResponse.setStatusCode("200");
        baseResponse.setStatusMsg("success");
        baseResponse.setData(standard);
        return baseResponse;
    }

    @Override
    public BaseResponse updatestandard(StandardDto standardDto) {
        BaseResponse baseResponse = new BaseResponse();
        Standard standard = standardRepo.findById(standardDto.getId()).orElse(null);
        standard.setId(standardDto.getId());
        standard.setName(standardDto.getName());
        standard.setCode(standardDto.getCode());
        standard.setCreatedAt(new Timestamp(new java.util.Date().getTime()));
        standard.setUpdatedAt(new Timestamp(new java.util.Date().getTime()));
        standard.setIsActive(0);
        standard.setIsDeleted(0);
        standardRepo.save(standard);
        baseResponse.setStatusCode("200");
        baseResponse.setStatusMsg("success");
        baseResponse.setData(standard);
        return baseResponse;
    }

    @Override
    public BaseResponse IsActivestandard(StandardDto standardDto) {
        BaseResponse baseResponse = new BaseResponse();
        Standard standard = standardRepo.findById(standardDto.getId()).orElse(null);
        standard.setId(standardDto.getId());
        standard.setIsActive(1);
        standardRepo.save(standard);
        baseResponse.setStatusCode("200");
        baseResponse.setStatusMsg("success");
        baseResponse.setData(standard);
        return baseResponse;
    }

    @Override
    public BaseResponse IsDeletedstandard(StandardDto standardDto) {
        BaseResponse baseResponse = new BaseResponse();
        Standard standard = standardRepo.findById(standardDto.getId()).orElse(null);
        standard.setId(standardDto.getId());
        standard.setIsDeleted(1);
        standardRepo.save(standard);
        baseResponse.setStatusCode("200");
        baseResponse.setStatusMsg("success");
        baseResponse.setData(standard);
        return baseResponse;
    }

    @Override
    public BaseResponse savesubject(SubjectDto subjectDto) {
        BaseResponse baseResponse = new BaseResponse();
        ModelMapper modelMapper = new ModelMapper();
        Subject subject = modelMapper.map(subjectDto, Subject.class);
        subjectRepo.save(subject);
        baseResponse.setStatusCode("200");
        baseResponse.setStatusMsg("success");
        baseResponse.setData(subject);
        return baseResponse;
    }

    @Override
    public BaseResponse getAllsubject() {
        BaseResponse baseResponse = new BaseResponse();
        List<Subject> subjectList = subjectRepo.findAll();
        baseResponse.setStatusCode("200");
        baseResponse.setStatusMsg("success");
        baseResponse.setData(subjectList);
        return baseResponse;
    }

    @Override
    public BaseResponse getsubjectById(int id) {
        BaseResponse baseResponse = new BaseResponse();
        Subject subject = subjectRepo.findById(id).orElse(null);
        baseResponse.setStatusCode("200");
        baseResponse.setStatusMsg("success");
        baseResponse.setData(subject);
        return baseResponse;
    }

    @Override
    public BaseResponse updatesubject(SubjectDto subjectDto) {
        BaseResponse baseResponse = new BaseResponse();
        Subject subject = subjectRepo.findById(subjectDto.getId()).orElse(null);
        subject.setId(subjectDto.getId());
        subject.setSubjectName(subjectDto.getSubjectName());
        subject.setCreatedAt(new Timestamp(new java.util.Date().getTime()));
        subject.setUpdatedAt(new Timestamp(new java.util.Date().getTime()));
        subject.setIsActive(0);
        subject.setIsDeleted(0);
        subjectRepo.save(subject);
        baseResponse.setStatusCode("200");
        baseResponse.setStatusMsg("success");
        baseResponse.setData(subject);
        return baseResponse;
    }

    @Override
    public BaseResponse IsActivesubject(SubjectDto subjectDto) {
        BaseResponse baseResponse = new BaseResponse();
        Subject subject = subjectRepo.findById(subjectDto.getId()).orElse(null);
        subject.setId(subjectDto.getId());
        subject.setIsActive(1);
        subjectRepo.save(subject);
        baseResponse.setStatusCode("200");
        baseResponse.setStatusMsg("success");
        baseResponse.setData(subject);
        return baseResponse;
    }

    @Override
    public BaseResponse IsDeletedsubject(SubjectDto subjectDto) {
        BaseResponse baseResponse = new BaseResponse();
        Subject subject = subjectRepo.findById(subjectDto.getId()).orElse(null);
        subject.setId(subjectDto.getId());
        subject.setIsDeleted(0);
        subjectRepo.save(subject);
        baseResponse.setStatusCode("200");
        baseResponse.setStatusMsg("success");
        baseResponse.setData(subject);
        return baseResponse;
    }

    @Override
    public BaseResponse saveEverything(StandardDto standardDto) {
        BaseResponse baseResponse = new BaseResponse();
        try {
            ModelMapper modelMapper = new ModelMapper();
            Standard standard = modelMapper.map(standardDto, Standard.class);
            standard.setCreatedAt(new Timestamp(new java.util.Date().getTime()));
            standard.setUpdatedAt(new Timestamp(new java.util.Date().getTime()));
            standard.setIsActive(0);
            standard.setIsDeleted(0);
            Optional<Section> section=sectionRepo.findById(standard.getSectionid());
             if (section.isPresent()){
                 standard.setSectionid(section.get());
             }
            standard = standardRepo.save(standard);
           savestandardMedium(standardDto.getMediumDtoList(),standard);
           savestandardsubject(standardDto.getSubjectDtoList(),standard);
           savesubjectstaff(standardDto.getSubjectDtoList(),standardDto.getStaffDtoList(),standard);
            baseResponse.setStatusCode("200");
            baseResponse.setStatusMsg("sucess");
            baseResponse.setData(standard);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return baseResponse;
    }

    @Override
    public PageResponse<Standard> getByname(Integer pageNo, Integer pageSize, String sortBy, String name) {
        Pageable paging = PageRequest.of(pageNo, pageSize, Sort.by(Sort.Direction.DESC, sortBy));
        Page<Standard> standardPage = standardRepo.searchAllnameByLike("%" + name + "%",paging);
        ApiResponse apiResponse=new ApiResponse();
        apiResponse.setResponse(standardPage);
        apiResponse.setRecordCount(standardPage.getTotalPages());
        return null;
    }

    private void savestandardMedium(List<MediumDto> mediumDtoList, Standard standard) {
        BaseResponse baseResponse = new BaseResponse();
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
                baseResponse.setStatusMsg("success");
                baseResponse.setStatusCode("200");
                baseResponse.setData(standardMedium);

            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    private void savestandardsubject(List<SubjectDto> subjectDtoList, Standard standard) {
        BaseResponse baseResponse = new BaseResponse();
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
                baseResponse.setStatusMsg("success");
                baseResponse.setStatusCode("200");
                baseResponse.setData(standardSubject);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void savesubjectstaff(List<SubjectDto> subjectList,List<StaffDto> staffList,Standard standard) {
        BaseResponse baseResponse = new BaseResponse();
        try {
            SubjectStaff subjectStaff = new SubjectStaff();
            List<SubjectStaff> subjectStaffs = new LinkedList<>();
            if (Objects.nonNull(subjectList) && subjectList.size() > 0) {
                subjectList.stream().forEachOrdered(subjects -> {
                    Subject subject = subjectRepo.findById(subjects.getId())
                            .orElseThrow(() -> new RuntimeException("id is not here"));
                    subjectStaff.setSubject(subject);
                    staffList.stream().forEachOrdered(staff -> {
                        Staff staff1=staffRepo.findById(staff.getId())
                                .orElseThrow(() -> new RuntimeException("id is not here"));
                        subjectStaff.setStaff1(staff1);
                    });
                });
                subjectStaffs.add(subjectStaff);
                subjectStaffRepo.saveAll(subjectStaffs);
                baseResponse.setStatusMsg("success");
                baseResponse.setStatusCode("200");
                baseResponse.setData(subjectStaff);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}



