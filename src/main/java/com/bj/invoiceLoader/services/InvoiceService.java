package com.bj.invoiceLoader.services;

import com.bj.invoiceLoader.entity.Invoice;
import com.bj.invoiceLoader.exception.FileStorageException;
import com.bj.invoiceLoader.repositories.InvoiceRepository;
import org.hibernate.JDBCException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class InvoiceService {

    @Autowired
    private InvoiceRepository invoiceRepository;

    public void saveInvoice(Invoice invoice) {
        try {
            invoiceRepository.save(invoice);
        } catch (JDBCException ex) {
            throw new FileStorageException("Could not store data " + ex);
        }
    }
}
