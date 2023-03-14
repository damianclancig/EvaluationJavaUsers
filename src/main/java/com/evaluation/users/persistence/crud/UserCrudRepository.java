package com.evaluation.users.persistence.crud;

import com.evaluation.users.persistence.entity.User;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

public interface UserCrudRepository extends CrudRepository<User, Long> {
    @Query(value = "SELECT * FROM users WHERE email = ?", nativeQuery = true)
    User findByEmail(String email);
}
