package task.com.example.demo.Serviceinterface;

import task.com.example.demo.DTO.SectionDto;
import task.com.example.demo.Model.Section;

import java.util.List;
import java.util.Optional;

public interface SectionInterface {
    Section savesection(SectionDto sectionDto);

    List<Section> getAllsection();

    Optional<Section>UpdateSectionById(SectionDto sectionDto);

    Optional<Section> IsDeletedSection(SectionDto sectionDto);
}
