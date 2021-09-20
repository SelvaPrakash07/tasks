package task.com.example.demo.Serviceinterface;

import task.com.example.demo.DTO.StaffDto;
import task.com.example.demo.DTO.SubjectDto;
import task.com.example.demo.Model.Subject;

import java.util.List;
import java.util.Optional;

public interface SubjectInterface {
    Subject savesubject(SubjectDto subjectDto, StaffDto staffDto);

    List<Subject> getAllsubject();

    Optional<Subject> UpdatesubjectById(SubjectDto subjectDto);

    Optional<Subject> IsDeletedsubject(SubjectDto subjectDto);
}
