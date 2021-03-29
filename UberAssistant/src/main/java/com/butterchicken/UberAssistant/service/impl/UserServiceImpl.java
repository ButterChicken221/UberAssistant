package com.butterchicken.UberAssistant.service.impl;

import com.butterchicken.UberAssistant.entity.User;
import com.butterchicken.UberAssistant.repo.UserRepo;
import com.butterchicken.UberAssistant.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepo userRepo;

    @Override
    public List<User> getAllUsers() {
        return userRepo.findAll();
    }
}
