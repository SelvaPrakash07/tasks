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
@Table(name = "staff")
public class Staff {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "staff_name")
    public String staffName;

    @ManyToMany(mappedBy ="staff")
    private List<Subject> subject;

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
            },
            mappedBy = "staff")
    private Set<Subject> subjectSet = new HashSet<>();
}


