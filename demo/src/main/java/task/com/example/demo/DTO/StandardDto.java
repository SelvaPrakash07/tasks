package task.com.example.demo.DTO;

import lombok.Getter;
import lombok.Setter;
import task.com.example.demo.Model.Section;

import java.sql.Timestamp;
import java.util.List;

@Getter
@Setter

public class StandardDto {
    private int id;
    public String name;
    public String code;
    public Timestamp createdAt;
    public Timestamp updatedAt ;
    public int isActive ;
    public int isDeleted;
    private int sectionId;
    private List<MediumDto> mediumDtoList;
    private  List<SubjectDto> subjectDtoList;
    private  List<StaffDto> staffDtoList;

}
