package com.auth.service;

import com.auth.dto.MessageResponse;
import com.auth.model.User;

import java.util.List;

public interface UserService {

    User getUserById(Long id);
    List<User> getAllUsers();
    User addUser(User user);
    User updateUser(Long id, User user);
    MessageResponse deleteUser(Long id);

}
