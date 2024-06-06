package com.example.demo2.service;

import com.example.demo2.repository.RoleRepos;
import com.example.demo2.repository.UserRepos;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Autowired
    private RoleRepos roleRepo;

    @Autowired
    private UserRepos userRepo;


}
