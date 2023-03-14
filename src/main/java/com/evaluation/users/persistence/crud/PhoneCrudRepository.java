package com.evaluation.users.persistence.crud;

import com.evaluation.users.persistence.entity.Phone;
import org.springframework.data.repository.CrudRepository;

public interface PhoneCrudRepository extends CrudRepository<Phone, Long> {
}
