package com.vikings.gym.service;

import com.vikings.gym.model.User;
import jakarta.transaction.Transactional;

import java.util.Optional;

public interface IUserService {
    User saveUser(User user);

    Optional<User> findByUsername(String username);
    @Transactional
    void makeCoach(String username);


    @Transactional
    void makeAdmin(String username);
}
