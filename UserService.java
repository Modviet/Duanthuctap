package com.example.demo2.service;

import com.example.demo2.model.User;
import com.example.demo2.repository.ConfirmEmailRepos;
import com.example.demo2.repository.RoleRepos;
import com.example.demo2.repository.UserRepos;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    @Autowired
    private RoleRepos roleRepo;

    @Autowired
    private UserRepos userRepo;

    @Autowired
    private ConfirmEmailRepos conRepo;

    public Optional<User> getUserById(int id) {
        return userRepo.findById(id);
    }

    public User updateUser(User userDetails) {
        User user = userRepo.findById(userDetails.getId())
                .orElseThrow(() -> new RuntimeException("User not found"));
        return userRepo.save(user);
    }

    public void resetPassword(String email, String newPassword) {
        User user = userRepo.findByEmail(email)
                .orElseThrow(() -> new RuntimeException("User not found"));
        user.setPassword(newPassword);
        userRepo.save(user);
    }

    public Optional<User> getUserByEmail(String email) {
        return userRepo.findByEmail(email);
    }

    public List<User> getAll(){
        return userRepo.findAll();
    }

    public User findById(int id){
        return userRepo.findById(id).orElseThrow(()->new IllegalArgumentException("User not found"));
    }
}
