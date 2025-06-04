package com.Shift.Management.Shift.Management.Services;

import com.Shift.Management.Shift.Management.Controller.UserController;
import com.Shift.Management.Shift.Management.Dto.UserDto;
import com.Shift.Management.Shift.Management.Entity.UserEntity;
import com.Shift.Management.Shift.Management.Repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserImplementation {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    private UserController userController;

    @Autowired
    public void UserService(UserController userController) {
        this.userController = userController;
    }

    public UserImplementation(UserController userController) {
        this.userController = userController;
    }

    public void registerNewUser(UserDto request) {
        if (userRepository.findById(Long.valueOf(request.getUsername())).isPresent()) {
            throw new RuntimeException("Username already exists");
        }
        UserEntity userEntity = new UserEntity();
        userEntity.setUsername(request.getUsername());
        userEntity.setPassword(passwordEncoder.encode(request.getPassword())); // hash password
        userRepository.save(userEntity);
    }

    public UserDetails loadUserById(Long id) {
        return null;
    }
}

