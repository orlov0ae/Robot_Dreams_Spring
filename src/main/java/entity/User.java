package entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Data
@Entity
@Component
@Table(name = "users", schema = "robot_dreams_advanced")
@AllArgsConstructor
@NoArgsConstructor(force = true)
@Builder
@Getter
@Setter
@Scope("session")
public class User {

    @Id
    @GeneratedValue
    private Long id;
    private String name;

    @JsonIgnore
    private String password;
    @ManyToMany
    @JoinTable(name = "user_roles", schema = "robot_dreams_advanced", joinColumns = {
            @JoinColumn(name = "user_id", nullable= false)
        }, inverseJoinColumns = {
            @JoinColumn(name = "role_id", nullable = false)
    })

    private List<Role> roleList = new ArrayList<>();

    @ManyToOne
    @JoinColumn(name = "computer_id")
    private Computer computer;






    public void logIn() {
        computer.turnOn();
        System.out.println("The user is logged in");
    }

    public void logOut() {
        System.out.println("The user is logged out");
    }


}
