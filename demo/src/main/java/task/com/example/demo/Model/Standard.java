package task.com.example.demo.Model;

import lombok.Getter;
import lombok.Setter;
import task.com.example.demo.DTO.MediumDto;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.List;

@Getter
@Setter
@Entity
@Table(name = "standard")
public class Standard {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "name")
    public String name;

    @Column(name = "code")
    public String code;

    @Column(name="created_at")
    public Timestamp createdAt;

    @Column(name="updated_at")
    public Timestamp updatedAt ;

    @Column(name="Is_Active")
    public int isActive ;

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

    public int getSectionid() {
        return 0;
    }

    public void setSectionid(Section sectionid) {
        this.sectionid = sectionid;
    }


    public List<StandardMedium> getStandardMediumList() {
        return standardMediumList;
    }

    public void setStandardMediumList(List<StandardMedium> standardMediumList) {
        this.standardMediumList = standardMediumList;
    }

    public List<StandardSubject> getStandardSubjectList() {
        return standardSubjectList;
    }

    public void setStandardSubjectList(List<StandardSubject> standardSubjectList) {
        this.standardSubjectList = standardSubjectList;
    }

    @Column(name="Is_Deleted")
    public int isDeleted;

    @OneToOne
    @JoinColumn(name="section_id_fk")
    private Section sectionid;

    @OneToMany(mappedBy = "medium1")
    private List<StandardMedium> standardMediumList;

    @OneToMany(mappedBy = "subject1")
    private List<StandardSubject> standardSubjectList;

}
