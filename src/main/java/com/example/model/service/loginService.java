package com.example.model.service;


import com.example.model.bo.User;
import org.springframework.stereotype.Service;


public interface loginService {
    public User LoginVerification(User user);
}
