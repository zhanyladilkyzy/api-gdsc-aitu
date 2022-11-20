package kz.aitu.apigdsc.service.user;

import kz.aitu.apigdsc.model.user.UserRequest;
import kz.aitu.apigdsc.model.user.UserResponse;

import java.util.List;

public interface UserService {
    
    UserResponse createUser(UserRequest userRequest);

    UserResponse updateUser(UserRequest userRequest);

    UserResponse getUserById(String userId);

    List<UserResponse> getAllUsers();

    void deleteUserById(String userId);
}
