package controller;

import entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import service.ServiceBean;

@RestController
@RequestMapping("api/test/users")
@CrossOrigin("*")
public class ServiceBeanController {

    private final ServiceBean serviceBean;


    @Autowired
    public ServiceBeanController (ServiceBean serviceBean) {
        this.serviceBean = serviceBean;
    }

    @GetMapping("/hello")
    public void hello(){
        System.out.println("Hello");
    }

    @PreAuthorize("hasRole('USER')")
    @GetMapping("/parameter/{userName}")
    public ResponseEntity<User> getName(@PathVariable("userName") String userName) {
        return ResponseEntity.ok(serviceBean.getByName(userName));
    }



    @PreAuthorize("hasRole('USER')")
    @GetMapping("/userAdd")
    public ResponseEntity<User> addUser(@RequestBody User user){
        return ResponseEntity.ok(serviceBean.add(user));
    }


    @PreAuthorize("hasRole('USER')")
    @GetMapping("/deleteUser/{userName}")
    public ResponseEntity<User> deleteUser(@PathVariable("userName") User user) {
        return ResponseEntity.ok(serviceBean.remove(user));
    }

    @PreAuthorize("hasRole('USER')")
    @GetMapping("/userUpdate")
    public ResponseEntity<User> updateUser(@RequestBody User user) {
        return ResponseEntity.ok(serviceBean.update(user));
    }

}
