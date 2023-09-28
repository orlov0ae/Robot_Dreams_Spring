package entity;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
@Scope("session")
public class User {


    private final String id;
    private final String name;
    private final Computer computer;


    @Autowired
    public User(String id, String name, Computer computer) {
        this.id = id;
        this.name = name;
        this.computer = computer;
    }

    public void logIn() {
        computer.turnOn();
        System.out.println("The user is logged in");
    }

    public void logOut() {
        System.out.println("The user is logged out");
    }

    @Override
    public String toString() {
        return "User{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", computer=" + computer +
                '}';
    }
}
