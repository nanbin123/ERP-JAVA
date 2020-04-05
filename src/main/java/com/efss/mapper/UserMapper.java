package com.efss.mapper;

import com.efss.entity.user.User;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface UserMapper {



    List<User> hellowSelectUser();


    /**
     * 通过用户名查找用户对象
     */
    User getUserByUsername(@Param("phone")String phone);
}
