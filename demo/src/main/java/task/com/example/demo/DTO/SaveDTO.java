package task.com.example.demo.DTO;

import java.sql.Timestamp;
import java.util.List;

public class SaveDTO {
    private int id;
    public String name;
    public String code;
    public Timestamp createdAt;
    public Timestamp updatedAt ;
    public int isActive ;
    public int isDeleted;
    List<MediumDto> mediumDtoList;

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

    public List<MediumDto> getMediumDtoList() {
        return mediumDtoList;
    }

    public void setMediumDtoList(List<MediumDto> mediumDtoList) {
        this.mediumDtoList = mediumDtoList;
    }

    public List<SubjectNdStaffDto> getSubjectNdStaffDtos() {
        return subjectNdStaffDtos;
    }

    public void setSubjectNdStaffDtos(List<SubjectNdStaffDto> subjectNdStaffDtos) {
        this.subjectNdStaffDtos = subjectNdStaffDtos;
    }

    List<SubjectNdStaffDto> subjectNdStaffDtos;
}
