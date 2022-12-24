package com.saraf.myapp.service;

import com.saraf.myapp.entity.User;

public interface UserService {
    User getUser(Long id);
    User getUser(String username);
    User saveUser(User user);
}
