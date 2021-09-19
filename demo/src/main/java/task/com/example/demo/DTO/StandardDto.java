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
private List<MediumDto> mediumDtoList;
private  List<SubjectDto> subjectDtoList;
private  List<StaffDto> staffDtoList;

    public List<StaffDto> getStaffDtoList() {
        return staffDtoList;
    }

    public void setStaffDtoList(List<StaffDto> staffDtoList) {
        this.staffDtoList = staffDtoList;
    }

    public List<SubjectDto> getSubjectDtoList() {
        return subjectDtoList;
    }

    public void setSubjectDtoList(List<SubjectDto> subjectDtoList) {
        this.subjectDtoList = subjectDtoList;
    }

    private int sectionid;

    public int getSectionid() {
        return sectionid;
    }

    public void setSectionid(int sectionid) {
        this.sectionid = sectionid;
    }

    public List<MediumDto> getMediumDtoList() {
        return mediumDtoList;
    }

    public void setMediumDtoList(List<MediumDto> mediumDtoList) {
        this.mediumDtoList = mediumDtoList;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public Timestamp getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Timestamp createdAt) {
        this.createdAt = createdAt;
    }

    public Timestamp getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(Timestamp updatedAt) {
        this.updatedAt = updatedAt;
    }

    public int getIsActive() {
        return isActive;
    }

    public void setIsActive(int isActive) {
        this.isActive = isActive;
    }

    public int getIsDeleted() {
        return isDeleted;
    }

    public void setIsDeleted(int isDeleted) {
        this.isDeleted = isDeleted;
    }


}
