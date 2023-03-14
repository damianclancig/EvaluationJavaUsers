package com.evaluation.users.persistence;

import com.evaluation.users.persistence.crud.PhoneCrudRepository;
import com.evaluation.users.persistence.entity.Phone;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class PhoneRepository {

    @Autowired
    private PhoneCrudRepository phoneCrudRepository;

    public Phone save (Phone phone) {
        return phoneCrudRepository.save(phone);
    }

    public List<Phone> saveAll(List<Phone> phones) {
        return (List<Phone>) phoneCrudRepository.saveAll(phones);
    }
}
