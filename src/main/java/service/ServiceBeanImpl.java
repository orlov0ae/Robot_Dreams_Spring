package service;

import entity.User;
import jakarta.annotation.PostConstruct;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
public class ServiceBeanImpl implements ServiceBean {

    private Map<String, User> users = new HashMap<>();

    @Override
    public User getByName(String name) {
        return users.get(name);
    }

    @Override
    public User add(User user) {
        users.put(String.valueOf(user.getId()), user);
        return user;
    }

    @Override
    public User remove(User user) {
        return users.remove(user.getName());
    }

    @Override
    public User update(User user) {
        users.put(String.valueOf(user.getId()), user);
        return user;
    }

    @Bean
    @PostConstruct
    public void exampleUser() {
        User one = User.builder().id(1L).name("One").build();
        User two = User.builder().id(2L).name("Two").build();
        users.put("1", one);
        users.put("2", two);
    }
}
