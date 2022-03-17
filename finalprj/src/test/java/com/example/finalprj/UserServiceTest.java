package com.example.finalprj;

import com.example.finalprj.model.User;
import com.example.finalprj.repository.UserRepository;
import com.example.finalprj.service.UserService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentCaptor;
import org.mockito.Captor;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class UserServiceTest {

    @Mock
    UserRepository userRepository;

    @Mock
    PasswordEncoder passwordEncoder;

    @Captor
    ArgumentCaptor<User> userCaptor;

    UserService userService;

    @BeforeEach
    void init() {
        userService = new UserService(userRepository, passwordEncoder);
    }

    @Test
    void saveUser() {
        var encoded = "encoded";
        var user = new User("vitalir", "12345");
        when(passwordEncoder.encode(any())).thenReturn(encoded);
        userService.saveUser(user);
        verify(userRepository).save(userCaptor.capture());
        var resultUser = userCaptor.getValue();
        assertEquals(new User("vitalir", encoded), resultUser);
    }

    @Test
    void getUsers() {
        var encoded = "encoded";
        var fakeUsers = List.of(
                new User("vitalir", encoded),
                new User("admin", encoded)
        );
        when(userRepository.findAll()).thenReturn(fakeUsers);
        var result = userService.getUsers();
        assertEquals(fakeUsers, result);
    }
}
