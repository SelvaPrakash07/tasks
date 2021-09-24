package task.com.example.demo.DTO;

import jdk.jfr.SettingDefinition;
import lombok.Getter;
import lombok.Setter;

import java.sql.Timestamp;
import java.util.List;

@Getter
@Setter
public class SaveDTO {
    private int id;
    public String name;
    public String code;
    public Timestamp createdAt;
    public Timestamp updatedAt ;
    public int isActive ;
    public int isDeleted;
    List<MediumDto> mediumDtoList;
    List<SubjectNdStaffDto> subjectNdStaffDtos;
}
