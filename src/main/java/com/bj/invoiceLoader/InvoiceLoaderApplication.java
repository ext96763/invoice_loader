package com.bj.invoiceLoader;

import com.bj.invoiceLoader.controllers.FileLoadController;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.io.File;

@SpringBootApplication
public class InvoiceLoaderApplication {

	public static void main(String[] args) {
		new File(FileLoadController.uploadingDir).mkdirs();
		SpringApplication.run(InvoiceLoaderApplication.class, args);
	}
}
