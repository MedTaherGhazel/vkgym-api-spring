package com.vikings.gym.service;

import com.vikings.gym.model.User;

import java.util.Optional;

public interface IUserService {
    User saveUser(User user);

    Optional<User> findByUsername(String username);
    void MakeCoach(String username);

    void MakeAdmin(String username);
}
