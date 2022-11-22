package kz.aitu.apigdsc.controller;

import kz.aitu.apigdsc.model.user.UserRequest;
import kz.aitu.apigdsc.model.user.UserResponse;
import kz.aitu.apigdsc.service.user.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    UserService userService;

    @GetMapping("/all")
    public List<UserResponse> getAllUsers() {
        return userService.getAllUsers();
    }

    @GetMapping("/{userId}")
    public UserResponse getUser(@PathVariable String userId) {
        return userService.getUserById(userId);
    }

    @PostMapping
    public UserResponse addUser(@RequestBody UserRequest user) {
        return userService.createUser(user);
    }

    @PutMapping("/{userId}")
    public UserResponse updateUser(@PathVariable String userId, @RequestBody UserRequest user) {
        user.setUserId(userId);
        return userService.updateUser(user);
    }

    @DeleteMapping("/{userId}")
    public void deleteUser(@PathVariable String userId) {
        userService.deleteUserById(userId);
    }

}
