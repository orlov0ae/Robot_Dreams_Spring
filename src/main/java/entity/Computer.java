package entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor
@Builder
@Getter
@Setter
@Scope("singleton")
public class Computer {

    private String id;
    private String processor;
    private String capacity;

    public void turnOn() {
        System.out.println("Computer is turn on");
    }

}
