package com.bj.invoiceLoader.services;

import com.bj.invoiceLoader.entity.User;
import com.bj.invoiceLoader.repositories.UserRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TestService {

    Logger logger = LoggerFactory.getLogger(TestService.class);
    @Autowired
    private UserRepository userRepository;

    public List<User> findAll() {
        logger.debug(String.valueOf(userRepository.findAll()));
        return (List<User>) userRepository.findAll();
    }

}
