package com.example.model.mapper;
import com.example.model.bo.User;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface loginMapper {
    User selectUserByPassword(User user);
}
