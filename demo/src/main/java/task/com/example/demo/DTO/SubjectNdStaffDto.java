package task.com.example.demo.DTO;

import lombok.Getter;
import lombok.Setter;

import java.sql.Timestamp;
import java.util.List;

@Getter
@Setter
public class SubjectNdStaffDto {

    private int id;
    public String subjectName;
    public String code;
    public Timestamp createdAt;
    public Timestamp updatedAt;
    public int isActive;
    public int isDeleted;
    List<StaffDto> staffDtos;

}

