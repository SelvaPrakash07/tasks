package task.com.example.demo.DTO;

import java.sql.Timestamp;
import java.util.List;

public class SubjectNdStaffDto {

private int id;
    public String subjectName;
    public String code;
    public Timestamp createdAt;
    public Timestamp updatedAt ;
    public int isActive ;
    public int isDeleted;
List<StaffDto> staffDtos;

    public List<StaffDto> getStaffDtos() {
        return staffDtos;
    }

    public void setStaffDtos(List<StaffDto> staffDtos) {
        this.staffDtos = staffDtos;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getSubjectName() {
        return subjectName;
    }

    public void setSubjectName(String subjectName) {
        this.subjectName = subjectName;
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

