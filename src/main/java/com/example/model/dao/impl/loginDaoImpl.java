package com.example.model.dao.impl;

import com.example.model.bo.User;
import com.example.model.dao.loginDao;
import com.example.model.mapper.loginMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

/**
 * @author YangChenxi
 * @CreateTime 2024-10-09
 */

@Repository
public class loginDaoImpl implements loginDao {

    @Autowired
    private loginMapper loginmapper;
    @Override
    public User LoginVerification(User user) {
        User result = loginmapper.selectUserByPassword(user);
        if(result != null){
            return result;
        }else{
            return null;
        }
    }
}
