package com.bj.invoiceLoader.repositories;

import com.bj.invoiceLoader.entity.File;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

@Repository
@Component
public interface FileRepository extends CrudRepository<File, String> {
}