package com.example.demo2.service;

import com.example.demo2.model.User;
import com.example.demo2.repository.ConfirmEmailRepos;
import com.example.demo2.repository.RoleRepos;
import com.example.demo2.repository.UserRepos;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
        user.setId(userDetails.getId());
        user.setUsername(userDetails.getUsername());
        user.setCreateTime(userDetails.getCreateTime());
        user.setAvatar(userDetails.getAvatar());
        user.setFullName(userDetails.getFullName());
        user.setDateOfBirth(userDetails.getDateOfBirth());
        user.setAddress(userDetails.getAddress());
        user.setEmail(userDetails.getEmail());
        user.setPassword(userDetails.getPassword());
        user.setCreateTime(userDetails.getCreateTime());
        user.setIsActive(userDetails.getIsActive());
        user.setUserStatus(userDetails.getUserStatus());
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


}
