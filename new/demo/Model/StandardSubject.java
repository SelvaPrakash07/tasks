package task.com.example.demo.Model;


import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@Entity
@Table(name = "standard_subject")
public class StandardSubject {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @OneToOne
    @JoinColumn(name = "standard_fk_id")
    private Standard standard;

    @ManyToOne
    @JoinColumn(name = "subject_fk_id")
    private Subject subject1;

}
