package kz.aitu.apigdsc.service.user;

import kz.aitu.apigdsc.model.user.UserRequest;
import kz.aitu.apigdsc.model.user.UserResponse;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements  UserService {

    @Override
    public UserResponse createUser(UserRequest userRequest) {
        return null;
    }

    @Override
    public UserResponse updateUser(UserRequest userRequest) {
        return null;
    }

    @Override
    public UserResponse getUserById(String userId) {
        return null;
    }

    @Override
    public List<UserResponse> getAllUsers() {
        return null;
    }

    @Override
    public void deleteUserById(String userId) {

    }
}
