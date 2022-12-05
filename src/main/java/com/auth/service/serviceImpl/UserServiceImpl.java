package com.auth.service.serviceImpl;

import com.auth.dto.MessageResponse;
import com.auth.model.User;
import com.auth.repository.UserRepository;
import com.auth.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public User getUserById(Long id) {
        return userRepository.findById(id).orElseThrow(() -> new RuntimeException("User not found"));
    }

    @Override
    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    @Override
    public User addUser(User user) {
        if(userRepository.existsByUsername(user.getUsername())
                || userRepository.existsByEmail(user.getEmail())) {
            throw new RuntimeException("User already exists");
        }
        return userRepository.save(user);
    }

    @Override
    public User updateUser(Long id, User user) {
        if(!userRepository.existsByUsername(user.getUsername())) {
            throw new RuntimeException("User not found");
        }
        user.setId(id);
        return userRepository.save(user);
    }

    @Override
    public MessageResponse deleteUser(Long id) {
        if(!userRepository.existsById(id)) throw new RuntimeException("User not found");
        userRepository.deleteById(id);
        return new MessageResponse("User deleted successfully");
    }
}
