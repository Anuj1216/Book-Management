package com.anuj.bookmanagement.services;

import com.anuj.bookmanagement.entities.User;
import com.anuj.bookmanagement.repositories.UserRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {
    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public List<User> getUsers() {
        return userRepository.findAll();
    }

    public User getUserById(Long id) {
        return userRepository.findById(id).orElseThrow(() -> new RuntimeException("User with id " + id + " not found"));
    }

    public User addUser(User user) {
        return userRepository.save(user);
    }

    public User updateUser(User user) {
        User oldUser = getUserById(user.getId());
        oldUser.setName(user.getName());
        oldUser.setEmail(user.getEmail());
        oldUser.setPassword(user.getPassword());
        oldUser.setAddress(user.getAddress());
        return userRepository.save(oldUser);

    }

    public void deleteUser(User user) {
        userRepository.delete(user);
    }
}
