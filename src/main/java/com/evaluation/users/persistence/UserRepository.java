package com.evaluation.users.persistence;

import com.evaluation.users.persistence.crud.UserCrudRepository;
import com.evaluation.users.persistence.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class UserRepository {

    @Autowired
    private UserCrudRepository userCrudRepository;

    public List<User> getAll() {
        return (List<User>) userCrudRepository.findAll();
    }

    public User save (User user) {
        return userCrudRepository.save(user);
    }

    public User getUserByEmail(String email) {
        return userCrudRepository.findByEmail(email);
    }
}
