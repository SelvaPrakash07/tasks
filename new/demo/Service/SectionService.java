package task.com.example.demo.Service;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import task.com.example.demo.DTO.SectionDto;
import task.com.example.demo.Model.Medium;
import task.com.example.demo.Model.Section;
import task.com.example.demo.Repository.SectionRepo;
import task.com.example.demo.Serviceinterface.SectionInterface;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class SectionService implements SectionInterface {
    @Autowired
    private SectionRepo sectionRepo;

    @Override
    public Section savesection(SectionDto sectionDto) {
        ModelMapper modelMapper = new ModelMapper();
        Section section = modelMapper.map(sectionDto, Section.class);
        sectionRepo.save(section);
        return section;
    }

    @Override
    public List<Section> getAllsection() {
        List<Section> sectionList=sectionRepo.findAll();
        return sectionList;
    }

    @Override
    public Optional<Section> UpdateSectionById(SectionDto sectionDto) {
        Optional<Section> section = sectionRepo.findById(sectionDto.getId());
        if (section.isPresent())
        {section.get().setSectionName(sectionDto.getSectionName());
        }
        else
        {throw new RuntimeException("");
        }
        sectionRepo.save(section.get());
        return section;
    }

    @Override
    public Optional<Section> IsDeletedSection(SectionDto sectionDto) {
        Optional<Section> section = sectionRepo.findById(sectionDto.getId());
        if (section.isPresent())
        {
            section.get().setIsDeleted(1);
        }
        else
        {throw new RuntimeException(HttpStatus.NOT_FOUND.name());
        }
        sectionRepo.save(section.get());
        return section;
    }
    }
