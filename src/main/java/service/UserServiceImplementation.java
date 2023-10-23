package service;

import dto.UserDTO;
import entity.User;
import exceptions.DeleteException;
import mapper.UserMapper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import repo.UserRepo;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class UserServiceImplementation implements UserService {

    private final UserRepo userRepository;
    private final UserMapper userMapper;

    public UserServiceImplementation(UserRepo userRepository, UserMapper userMapper) {
        this.userRepository = userRepository;
        this.userMapper = userMapper;
    }

    @Transactional
    @Override
    public UserDTO newUser(UserDTO userDTO) {
        User user = userMapper.toEntity(userDTO);
        user = userRepository.save(user);
        return userMapper.toDTO(user);
    }

    @Transactional (readOnly = true)
    @Override
    public Optional getUser(Long id, UserDTO userDTO) {
        return userRepository.findById(id).map(userMapper::toDTO);
    }

    @Transactional
    @Override
    public UserDTO updateUser(Long id, UserDTO userDTO) {
        if (userRepository.existsById(id)) {
            User user = userMapper.toEntity(userDTO);
            user.setId(id);
            user=userRepository.save(user);
            return userMapper.toDTO(user);
        }
        return null;
    }

    @Transactional
    @Override
    public void deleteUser(Long id) {

        userRepository.deleteById(id);
        throw new DeleteException("Error, while deleting", 500);

    }

    @Transactional
    @Override
    public List<UserDTO> findAllUsers() {
        return userRepository.findAll().stream().map(userMapper::toDTO).collect(Collectors.toList());
    }
}
