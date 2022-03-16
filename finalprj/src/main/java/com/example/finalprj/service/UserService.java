package com.example.finalprj.service;

import com.example.finalprj.repository.UserRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
public class UserService implements UserDetailsService {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    public UserService(UserRepository userRepository, PasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
    }

    public void saveUser(com.example.finalprj.model.User user) {
        var hashedPassword = passwordEncoder.encode(user.getPassword());
        var hashedUserData = new com.example.finalprj.model.User(user.getName(), hashedPassword);
        userRepository.save(hashedUserData);
    }

    public Iterable<com.example.finalprj.model.User> getUsers() {
        return userRepository.findAll();
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        var user = userRepository.findById(username).orElseThrow();
        return new User(user.getName(), user.getPassword(), List.of());
    }
}
