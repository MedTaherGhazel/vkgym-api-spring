package com.vikings.gym.service;

import com.vikings.gym.model.Role;
import com.vikings.gym.model.User;
import com.vikings.gym.repository.UserRepository;
import jakarta.transaction.Transactional;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Optional;

@Service
public class UserService implements IUserService {
    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    public UserService(PasswordEncoder passwordEncoder, UserRepository userRepository) {
        this.passwordEncoder = passwordEncoder;
        this.userRepository = userRepository;
    }

    @Override
    public User saveUser(User user){
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        user.setRole(Role.USER);
        user.setCreateTime(LocalDateTime.now());
        return userRepository.save(user);
    }
    @Override
    public Optional<User> findByUsername(String username){
        return userRepository.findByUsername(username);
    }
    @Override
    @Transactional
    public void MakeCoach(String username){
        userRepository.updateUserRole(username, Role.COACH);
    }
    @Override
    @Transactional
    public void MakeAdmin(String username){
        userRepository.updateUserRole(username, Role.ADMIN);
    }
}
