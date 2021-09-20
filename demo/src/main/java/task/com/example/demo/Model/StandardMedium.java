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

    @OneToOne
    @JoinColumn(name = "standard_fk_id")
    private Standard standard;

    @ManyToOne
    @JoinColumn(name = "medium_fk_id")
    private Medium medium1;


}
