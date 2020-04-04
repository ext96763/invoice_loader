package com.bj.invoiceLoader.controllers;

import com.bj.invoiceLoader.config.CustomClientHttpRequestInterceptor;
import com.bj.invoiceLoader.entity.Invoice;
import com.bj.invoiceLoader.services.InvoiceService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.http.client.BufferingClientHttpRequestFactory;
import org.springframework.http.client.ClientHttpRequestInterceptor;
import org.springframework.http.client.SimpleClientHttpRequestFactory;
import org.springframework.http.client.support.BasicAuthenticationInterceptor;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping()
public class ApiController {

    private static final String URL_INVOICES_TEST = "https://app.fakturoid.cz/api/v2/accounts/bjsh/invoices.json";

    //    private RestTemplate restTemplate;
//
//    @Autowired
//    public ApiController(RestTemplateBuilder builder) {
//        this.restTemplate = builder.build();
//    }
    private static final String URL_INVOICE_TEST = "https://app.fakturoid.cz/api/v2/accounts/bjsh/invoices/14845360.json";
    private static final String URL_SUBJECTS_TEST = "https://app.fakturoid.cz/api/v2/accounts/bjsh/subjects.json";
    Logger logger = LoggerFactory.getLogger(ApiController.class);
    @Autowired
    private InvoiceService invoiceService;

    @RequestMapping(method = RequestMethod.GET, value = "/getallinvoices")
    @ResponseBody
    public void getAllInvoices() {
        RestTemplate restTemplate = new RestTemplate(new BufferingClientHttpRequestFactory(new SimpleClientHttpRequestFactory()));
        List<ClientHttpRequestInterceptor> interceptors = new ArrayList<>();
        interceptors.add(new CustomClientHttpRequestInterceptor());
        interceptors.add(new BasicAuthenticationInterceptor("bjshpujcovna@gmail.com",
                "b907210ea211ed21bac6d51e4a7c7ad72b21e10c"));
        restTemplate.setInterceptors(interceptors);
        HttpHeaders headers = new HttpHeaders();
        headers.set("User-Agent", "java (bjshpujcovna@gmail.com)");
        headers.setContentType(MediaType.APPLICATION_JSON);

        ResponseEntity<Invoice[]> response =
                restTemplate.getForEntity(
                        URL_INVOICES_TEST,
                        Invoice[].class);
        Invoice[] invoices = response.getBody();

        //Store invoices in DB
        for (int i = 0; i < invoices.length; i++) {
            invoiceService.saveInvoice(invoices[i]);
        }
    }


}
