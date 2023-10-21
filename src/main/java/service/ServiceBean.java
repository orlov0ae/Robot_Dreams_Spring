package service;


import entity.User;

public interface ServiceBean {

    User getByName (String name);
    User add (User user);
    User remove (User user);
    User update (User user);

}
