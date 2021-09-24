package task.com.example.demo.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import task.com.example.demo.Constants.MasterConstants;
import task.com.example.demo.DTO.StaffDto;
import task.com.example.demo.DTO.SubjectDto;
import task.com.example.demo.Model.Medium;
import task.com.example.demo.Model.Staff;
import task.com.example.demo.Model.Subject;
import task.com.example.demo.Repository.StaffRepo;
import task.com.example.demo.Repository.SubjectRepo;
import task.com.example.demo.Serviceinterface.SubjectInterface;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class SubjectService implements SubjectInterface {

    @Autowired
    private SubjectRepo subjectRepo;

    @Autowired
    private StaffRepo staffRepo;

    @Override
    public Subject savesubject(SubjectDto subjectDto,StaffDto staffDto) {
        // Create a Post
            Subject subject = new Subject();
            subject.setSubjectName(subjectDto.getSubjectName());
            subject.setCreatedAt(subjectDto.getCreatedAt());
            subject.setUpdatedAt(subjectDto.getUpdatedAt());
            subject.setIsDeleted(subjectDto.getIsDeleted());
            // Create two tags
            Staff staff = new Staff();
            staff.setId(staffDto.getId());
            staff.setStaffName(staffDto.getStaffName());
            staff.setCreatedAt(staffDto.getCreatedAt());
            staff.setUpdatedAt(staffDto.getUpdatedAt());
            staff.setIsDeleted(staffDto.getIsDeleted());
            Staff staff1 = new Staff();
        staff1.setId(staffDto.getId());
        staff1.setStaffName(staffDto.getStaffName());
        staff1.setCreatedAt(staffDto.getCreatedAt());
        staff1.setUpdatedAt(staffDto.getUpdatedAt());
        staff1.setIsDeleted(staffDto.getIsDeleted());
        // Add tag references in the post
            subject.getStaff().add(staff);
            subject.getStaff().add(staff1);
            // Add post reference in the tags
        subjectRepo.save(subject);
            return subject;
    }

    @Override
    public List<Subject> getAllsubject() {
        List<Subject> subjects=subjectRepo.findAll();
        return subjects;
    }

    @Override
    public Optional<Subject> UpdatesubjectById(SubjectDto subjectDto) {
        Optional<Subject> subject = subjectRepo.findById(subjectDto.getId());
        if (subject.isPresent())
        {subject.get().setSubjectName(subjectDto.getSubjectName());
            subject.get().setCreatedAt(subject.get().createdAt);
        }
        else
        {throw new RuntimeException(MasterConstants.ERROR_MESSAGE);
        }
        subjectRepo.save(subject.get());
        return subject;
    }

    @Override
    public Optional<Subject> IsDeletedsubject(SubjectDto subjectDto) {
        Optional<Subject> subject = subjectRepo.findById(subjectDto.getId());
        if (subject.isPresent())
        {
            subject.get().setIsDeleted(1);
        }
        else
        {throw new RuntimeException(MasterConstants.ERROR_MESSAGE);
        }
        subjectRepo.save(subject.get());
        return subject;
    }
}

