package unitTest;

import dto.UserDTO;
import entity.User;
import mapper.UserMapper;
import org.junit.Assert;
import org.junit.Test;
import org.junit.jupiter.api.BeforeEach;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import repo.UserRepo;
import service.UserServiceImplementation;

import java.util.Optional;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.assertEquals;


public class UserServiceImpTest {

    @Mock
    private UserRepo userRepository;
    @Mock
    private UserMapper userMapper;

    @InjectMocks
    private UserServiceImplementation userService;

    @BeforeEach
    public void setUp(){
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void setUser() {
        User user1 = new User();
        user1.setId(1L);
        user1.setName("User1");

        UserDTO user1DTO = new UserDTO();
        user1DTO.setId(1L);
        user1DTO.setName("User1");

        when(userRepository.save(any())).thenReturn(user1);

        UserDTO resultDTO = userService.newUser(user1DTO);

        verify(userMapper, times(2)).toEntity(user1DTO);
        assertEquals(1L, resultDTO.getId());
    }

    @Test
    public void testUser() {
        User user1 = new User();
        user1.setId(1L);
        user1.setName("User1");

        UserDTO user1DTO = new UserDTO();
        user1DTO.setId(1L);
        user1DTO.setName("User1");

        given(userRepository.findById(1L)).willReturn(Optional.of(user1));

        Optional<UserDTO> resultDTO = userService.getUser(1L, new UserDTO());

        assertTrue(resultDTO.isPresent());
       assertEquals(1L, resultDTO.get().getId());

    }



}
