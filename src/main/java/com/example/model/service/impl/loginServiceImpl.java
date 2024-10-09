package com.example.model.service.impl;

import com.example.model.bo.User;
import com.example.model.dao.loginDao;
import com.example.model.service.loginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

/**
 * @author YangChenxi
 * @CreateTime 2024-10-09
 */

@Service
public class loginServiceImpl implements loginService {

    @Autowired
    private loginDao loginDao;

    @Override
    public User LoginVerification(User loginUser) {
        User user = loginDao.LoginVerification(loginUser);
        if (user != null && StringUtils.hasLength(user.getName()) && StringUtils.hasLength(user.getPassword())) {
            return user;
        }else{
            return null;
        }
    }
}
