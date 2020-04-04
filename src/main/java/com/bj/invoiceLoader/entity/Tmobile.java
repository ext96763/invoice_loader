package com.bj.invoiceLoader.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotBlank;

@Entity
public class Tmobile {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @NotBlank(message = "Phone is mandatory")
    private String phoneNumber;

    private String tariff;

    private String invoiceGroup;

    private String ico;

    private String customerCompanyName;

    private String recipientCompanyName;

    private Double numberOfItems;

    private Double priceBeforeSale;

    private Double sale;

    private Double finalPrice;

    private String excelId;

    public Tmobile() {
    }

    public Tmobile(@NotBlank(message = "Phone is mandatory") String phoneNumber, String tariff, String invoiceGroup, String ico, String customerCompanyName, String recipientCompanyName, Double numberOfItems, Double priceBeforeSale, Double sale, Double finalPrice, String excelId) {
        this.phoneNumber = phoneNumber;
        this.tariff = tariff;
        this.invoiceGroup = invoiceGroup;
        this.ico = ico;
        this.customerCompanyName = customerCompanyName;
        this.recipientCompanyName = recipientCompanyName;
        this.numberOfItems = numberOfItems;
        this.priceBeforeSale = priceBeforeSale;
        this.sale = sale;
        this.finalPrice = finalPrice;
        this.excelId = excelId;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getTariff() {
        return tariff;
    }

    public void setTariff(String tariff) {
        this.tariff = tariff;
    }

    public String getInvoiceGroup() {
        return invoiceGroup;
    }

    public void setInvoiceGroup(String invoiceGroup) {
        this.invoiceGroup = invoiceGroup;
    }

    public String getIco() {
        return ico;
    }

    public void setIco(String ico) {
        this.ico = ico;
    }

    public String getCustomerCompanyName() {
        return customerCompanyName;
    }

    public void setCustomerCompanyName(String customerCompanyName) {
        this.customerCompanyName = customerCompanyName;
    }

    public String getRecipientCompanyName() {
        return recipientCompanyName;
    }

    public void setRecipientCompanyName(String recipientCompanyName) {
        this.recipientCompanyName = recipientCompanyName;
    }

    public Double getNumberOfItems() {
        return numberOfItems;
    }

    public void setNumberOfItems(Double numberOfItems) {
        this.numberOfItems = numberOfItems;
    }

    public Double getPriceBeforeSale() {
        return priceBeforeSale;
    }

    public void setPriceBeforeSale(Double priceBeforeSale) {
        this.priceBeforeSale = priceBeforeSale;
    }

    public Double getSale() {
        return sale;
    }

    public void setSale(Double sale) {
        this.sale = sale;
    }

    public Double getFinalPrice() {
        return finalPrice;
    }

    public void setFinalPrice(Double finalPrice) {
        this.finalPrice = finalPrice;
    }

    public String getExcelId() {
        return excelId;
    }

    public void setExcelId(String excelId) {
        this.excelId = excelId;
    }
}
