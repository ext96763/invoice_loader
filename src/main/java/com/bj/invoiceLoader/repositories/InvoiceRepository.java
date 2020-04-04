package com.bj.invoiceLoader.repositories;

import com.bj.invoiceLoader.entity.Invoice;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

@Repository
@Component
public interface InvoiceRepository extends CrudRepository<Invoice, Long> {
}
