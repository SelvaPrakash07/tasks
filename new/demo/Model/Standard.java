package task.com.example.demo.Model;

import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;
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

    @CreationTimestamp
    @Column(name="created_at")
    public Timestamp createdAt;

    @UpdateTimestamp
    @Column(name="updated_at")
    public Timestamp updatedAt ;

    @Column(name="Is_Active")
    public int isActive ;

    @Column(name="Is_Deleted")
    public int isDeleted;

    @OneToOne
    @JoinColumn(name="section_fk_id")
    private Section sectionid;

    @OneToMany(mappedBy = "medium1")
    private List<StandardMedium> standardMediumList;

    @OneToMany(mappedBy = "subject1")
    private List<StandardSubject> standardSubjectList;

}
