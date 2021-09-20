package task.com.example.demo.Model;

import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Getter
@Setter
@Entity
@Table(name = "subject")
public class Subject {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "subject_name")
    public String subjectName;

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


    @ManyToMany(fetch = FetchType.LAZY,
            cascade = {
                    CascadeType.PERSIST,
                    CascadeType.MERGE
            })
    @JoinTable(name = "subject_staff",
            joinColumns = { @JoinColumn(name = "subject_fk_id") },
            inverseJoinColumns = { @JoinColumn(name = "staff_fk_id") })
    private Set<Staff> staff = new HashSet<>();







}


