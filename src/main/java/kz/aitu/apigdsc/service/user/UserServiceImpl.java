package kz.aitu.apigdsc.service.user;

import kz.aitu.apigdsc.model.user.UserRequest;
import kz.aitu.apigdsc.model.user.UserResponse;
import kz.aitu.apigdsc.repository.UserEntity;
import kz.aitu.apigdsc.repository.UserRepository;
import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
public class UserServiceImpl implements  UserService {

    @Autowired
    UserRepository userRepository;

    static ModelMapper modelMapper = new ModelMapper();

    static {
        modelMapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT);
    }

    @Override
    public UserResponse createUser(UserRequest userRequest) {
        userRequest.setUserId(UUID.randomUUID().toString());
        UserEntity userEntity = modelMapper.map(userRequest, UserEntity.class);
        userRepository.save(userEntity);
        return modelMapper.map(userEntity, UserResponse.class);
    }
    @Override
    public UserResponse getUserById(String userId) {
        UserEntity userEntity = userRepository.getUserEntityByUserId(userId);
        return modelMapper.map(userEntity, UserResponse.class);
    }

    @Override
    public UserResponse updateUser(UserRequest userRequest) {
        UserEntity dbEntity = userRepository.getUserEntityByUserId(userRequest.getUserId());
        UserEntity updatedEntity = modelMapper.map(userRequest, UserEntity.class);
        updatedEntity.setId(dbEntity.getId());
        userRepository.save(updatedEntity);
        return modelMapper.map(updatedEntity, UserResponse.class);
    }

    @Override
    public List<UserResponse> getAllUsers() {
        List<UserEntity> users = new ArrayList<>();
        userRepository.findAll().forEach(users::add);
        return users.stream().map(user -> modelMapper.map(user, UserResponse.class)).collect(Collectors.toList());
    }

    @Override
    public void deleteUserById(String userId) {
        UserEntity userEntity = userRepository.getUserEntityByUserId(userId);
        userRepository.deleteUserEntityById(userEntity.getId());
    }
}
