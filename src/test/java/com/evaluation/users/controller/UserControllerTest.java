package com.evaluation.users.controller;

import com.evaluation.users.exception.ApiRequestException;
import com.evaluation.users.persistence.entity.User;
import org.hibernate.mapping.Any;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;

class UserControllerTest {

    private UserController userController = new UserController();

    @Test
    void save_with_invalid_email() {
        User user = new User();
        user.setName("Damian clancig");
        user.setEmail("damian.clancig@ey.com.ar..");
        user.setPassword("password2A");

        Throwable exception = assertThrows(ApiRequestException.class, () ->{
            userController.save(user);
        });
        assertEquals("Email is not valid", exception.getMessage());
    }

}