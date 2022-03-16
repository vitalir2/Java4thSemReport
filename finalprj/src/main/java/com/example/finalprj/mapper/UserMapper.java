package com.example.finalprj.mapper;

import com.example.finalprj.model.RegistrationForm;
import com.example.finalprj.model.User;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@NoArgsConstructor
public class UserMapper {

    public User toData(RegistrationForm registrationForm) {
        return new User(
                registrationForm.getName(),
                registrationForm.getPassword()
        );
    }
}
