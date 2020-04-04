package com.bj.invoiceLoader.repositories;

import com.bj.invoiceLoader.entity.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@Component
public interface UserRepository extends CrudRepository<User, Long> {

    List<User> findByName(String name);
}
