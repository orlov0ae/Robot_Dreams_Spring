package service;

import entity.User;

import java.util.ArrayList;
import java.util.List;

public class Service {

    private List<User> users= new ArrayList<>();

    public void addUser(User user) {
        users.add(user);
    }

    public List<User> getUsers() {
        return users;
    }

}
