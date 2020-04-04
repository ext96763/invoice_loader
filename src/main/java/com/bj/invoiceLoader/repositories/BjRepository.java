package com.bj.invoiceLoader.repositories;

import com.bj.invoiceLoader.entity.Bj;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

@Repository
@Component
public interface BjRepository extends CrudRepository<Bj, Long> {
}
