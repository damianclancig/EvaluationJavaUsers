package com.evaluation.users.service;

import com.evaluation.users.persistence.PhoneRepository;
import com.evaluation.users.persistence.entity.Phone;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PhoneService {

    @Autowired
    private PhoneRepository phoneRepository;

    public Phone save(Phone phone) {
        return phoneRepository.save(phone);
    }

    public List<Phone> saveAll(List<Phone> phones) {
        return phoneRepository.saveAll(phones);
    }
}
