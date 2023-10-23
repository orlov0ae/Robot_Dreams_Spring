package entity;

import jakarta.persistence.*;
import lombok.*;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Data
@Entity
@Component
@Table(name = "computers", schema = "robot_dreams_advanced")
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Getter
@Setter
@EqualsAndHashCode
@ToString
@Scope("singleton")
public class Computer {

    @Id
    @GeneratedValue
    private Long id;
    private String processor;
    private String capacity;

    @OneToMany(mappedBy = "computer")
    private List<User> users = new ArrayList<>();

    public void turnOn() {
        System.out.println("Computer is turn on");
    }

}
