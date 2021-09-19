package task.com.example.demo.Model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;


@Getter
@Setter
@Entity
@Table(name = "standard_medium")

public class StandardMedium {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

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

    public Medium getMedium1() {
        return medium1;
    }

    public void setMedium1(Medium medium1) {
        this.medium1 = medium1;
    }

    @OneToOne
    @JoinColumn(name = "standard_fk_id")
    private Standard standard;

    @ManyToOne
    @JoinColumn(name = "medium_fk_id")
    private Medium medium1;


}
