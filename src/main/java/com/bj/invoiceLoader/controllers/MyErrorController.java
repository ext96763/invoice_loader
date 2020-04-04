package com.bj.invoiceLoader.controllers;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.web.servlet.error.ErrorController;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpServletRequest;

@Controller
public class MyErrorController implements ErrorController {

    Logger logger = LoggerFactory.getLogger(MyErrorController.class);

    public MyErrorController() {
    }

    @GetMapping(value = "/error")
    public String handleError(HttpServletRequest request) {

        Object status = request.getAttribute(RequestDispatcher.ERROR_STATUS_CODE);

        if (status != null) {

            Integer statusCode = Integer.valueOf(status.toString());

            if (statusCode == HttpStatus.NOT_FOUND.value()) {
                logger.error(" Request resulted in HTTP  " + status.toString() + " Request Path: " + request.getAttribute(RequestDispatcher.ERROR_REQUEST_URI));
                return "error-404";
            }
            if (statusCode == HttpStatus.METHOD_NOT_ALLOWED.value()) {
                logger.error(" Request resulted in HTTP  " + status.toString() + " Request Path: " + request.getAttribute(RequestDispatcher.ERROR_REQUEST_URI));
                return "error-405";
            } else if (statusCode == HttpStatus.INTERNAL_SERVER_ERROR.value()) {
                logger.error(" Request resulted in HTTP " + status.toString() + " Request Path: " + request.getAttribute(RequestDispatcher.ERROR_REQUEST_URI));
                return "error-500";
            }
        }
        return "error";
    }

    @Override
    public String getErrorPath() {
        return "/error";
    }

}