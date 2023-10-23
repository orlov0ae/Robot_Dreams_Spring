package controller;

import dto.UserDTO;
import entity.User;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import service.UserService;

@RestController("/api/users")
@AllArgsConstructor
public class UserController {

    private final UserService userService;

    @PreAuthorize("hasRole('USER')")
    @GetMapping("/userAdd")
    public ResponseEntity<UserDTO> addUser(@RequestBody User user){
        return ResponseEntity.ok(userService.newUser(new UserDTO()));
    }

    @PreAuthorize("hasRole('USER')")
    @GetMapping("/parameter/{userId}")
    public ResponseEntity<UserDTO> getUser(@PathVariable("userId") Long userId) {
        UserDTO result = (UserDTO) userService.getUser(userId, new UserDTO()).orElse(null);
        return ResponseEntity.ok(result);
    }

    @PreAuthorize("hasRole('USER')")
    @GetMapping("/deleteUser/{userId}")
    public ResponseEntity<UserDTO> deleteUser(@PathVariable("userId") Long userId) {
        return ResponseEntity.ok(userService.deleteUser(userId));
    }

    @PreAuthorize("hasRole('USER')")
    @GetMapping("/userUpdate")
    public ResponseEntity<UserDTO> updateUser(@RequestBody User user) {
        return ResponseEntity.ok(userService.updateUser(user.getId(), new UserDTO()));
    }

}
