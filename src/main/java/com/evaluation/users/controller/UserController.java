package com.evaluation.users.controller;

import com.evaluation.users.exception.ApiRequestException;
import com.evaluation.users.service.UserService;
import com.evaluation.users.persistence.entity.User;
import com.evaluation.users.validator.EmailValidator;
import com.evaluation.users.validator.PasswordValidator;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.security.Keys;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Calendar;
import java.util.Date;
import java.util.List;


@RestController
@RequestMapping("/users")
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping("/getUsers")
    public ResponseEntity<List<User>> getAll() {
        return new ResponseEntity<>(userService.getAll(), HttpStatus.OK);
    }

    @PostMapping("/save")
    public ResponseEntity<User> save(@RequestBody User user) {
        if (!EmailValidator.isValid(user.getEmail()))
            //throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Email is not valid");
            throw new ApiRequestException("Email is not valid");
        if (userService.getUserByEmail(user.getEmail()) != null)
            throw new ApiRequestException("Email is exists");
        if (!PasswordValidator.isValid(user.getPassword()))
            throw new ApiRequestException("Password is not valid");

        Date now = new Date();
        user.setCreated(now);
        user.setLastLogin(now);
        user.setActive(true);

        Calendar calendar = Calendar.getInstance();
        calendar.setTime(now);
        calendar.add(Calendar.DAY_OF_YEAR, 30);
        Date dateExp = calendar.getTime();
        String jws = Jwts.builder()
                .setIssuer("Dclan")
                .setSubject(user.getEmail())
                .setId(user.getName())
                .setIssuedAt(now)
                .setExpiration(dateExp)
                .signWith(Keys.secretKeyFor(SignatureAlgorithm.HS256))
                .compact();
        user.setToken(jws);
        return new ResponseEntity<>(userService.save(user), HttpStatus.CREATED);
    }

}
