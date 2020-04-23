package com.xian.service.impl;

import com.xian.dao.IUserDao;
import com.xian.domain.Role;
import com.xian.domain.UserInfo;
import com.xian.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.security.core.authority.SimpleGrantedAuthority;

import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;

import java.util.List;

@Service(value ="userService")
@Transactional
public class UserServiceImpl implements IUserService , UserDetailsService {
    @Autowired
    private IUserDao userDao;

    @Autowired
    private  PasswordEncoder passwordEncoder;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        UserInfo userInfo=null;
        try {
           userInfo = userDao.findByUsername(username);
        } catch (Exception e) {
            e.printStackTrace();
        }
        //这里的User是UserDetails的实现类   "{noop}" 表示密码是加密的。
        //User user = new User(userInfo.getUsername(),"{noop}"+userInfo.getPassword(),getAuthority(userInfo.getRoles()));
        User user = new User(userInfo.getUsername(),userInfo.getPassword(),userInfo.getStatus() == 0 ? false : true,true,true,true,getAuthority(userInfo.getRoles()));
        return user;
    }

    private List<SimpleGrantedAuthority> getAuthority(List<Role> roles) {
        List<SimpleGrantedAuthority> list = new ArrayList<>();
        for (Role role : roles) {
            list.add(new SimpleGrantedAuthority("ROLE_"+role.getRoleName()));
        }

        return list;
    }

    @Override
    public List<UserInfo> findAll() {

        return userDao.findAll();
    }

    @Override
    public void save(UserInfo user) {
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        userDao.save(user);
    }

    @Override
    public UserInfo findById(String id) {
        return userDao.findById(id);
    }



}
