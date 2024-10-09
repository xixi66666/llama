package com.example.model.dao;

import com.example.model.bo.User;
import org.springframework.stereotype.Component;



public interface loginDao {
    public User LoginVerification(User user);
}
