package com.xian.service;

import com.xian.domain.UserInfo;
import org.springframework.security.core.userdetails.UserDetailsService;

import java.util.List;

public interface IUserService  {
    List<UserInfo> findAll();

    void save(UserInfo user);

    UserInfo findById(String id);
}
