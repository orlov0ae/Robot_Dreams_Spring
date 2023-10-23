package service;


import dto.UserDTO;

import java.util.List;
import java.util.Optional;

public interface UserService {

    UserDTO newUser(UserDTO userDTO);
    Optional getUser (Long id, UserDTO userDTO);
    UserDTO updateUser (Long id, UserDTO userDTO);
    void deleteUser(Long id);
    List<UserDTO> findAllUsers();


}
