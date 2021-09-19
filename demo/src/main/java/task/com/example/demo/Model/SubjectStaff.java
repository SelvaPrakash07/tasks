package task.com.example.demo.Model;

import javax.persistence.*;

public class SubjectStaff {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @ManyToOne
    @JoinColumn(name = "subject_fk_id")
    private Subject subject;


    @ManyToOne
    @JoinColumn(name = "staff_fk_id")
    private Staff staff1;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Subject getSubject() {
        return subject;
    }

    public void setSubject(Subject subject) {
        this.subject = subject;
    }

    public Staff getStaff1() {
        return staff1;
    }

    public void setStaff1(Staff staff1) {
        this.staff1 = staff1;
    }

}
