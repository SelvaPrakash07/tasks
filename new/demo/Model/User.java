package task.com.example.demo.Model;


import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Setter
@Getter
@Entity
@Table(name="user")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "username")
    private String userName;

    @Column(name = "password")
    private String password;

    @OneToMany(mappedBy = "role")
    private List<UserRole> roles;

    public User(User user) {
        this.id = user.getId();
        this.roles = user.getRoles();
        this.userName = user.getUserName();
    }

    public User() {

    }
}

