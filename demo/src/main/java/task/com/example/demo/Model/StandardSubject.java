package task.com.example.demo.Model;


import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@Entity
@Table(name = "standard_subject")


public class StandardSubject {

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Standard getStandard() {
        return standard;
    }

    public void setStandard(Standard standard) {
        this.standard = standard;
    }

    public Subject getSubject1() {
        return subject1;
    }

    public void setSubject1(Subject subject1) {
        this.subject1 = subject1;
    }

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
