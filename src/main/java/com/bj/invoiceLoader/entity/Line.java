package com.bj.invoiceLoader.entity;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Line {

    @Id
    private String id;

    private String name;

    private String quantity;

    private String unit_name;

    private String unit_price;

    private String vat_rate;

    private String customId;

    public Line() {
    }

    public Line(String id, String name, String quantity, String unit_name, String unit_price, String vat_rate, String customId) {
        this.id = id;
        this.name = name;
        this.quantity = quantity;
        this.unit_name = unit_name;
        this.unit_price = unit_price;
        this.vat_rate = vat_rate;
        this.customId = customId;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getQuantity() {
        return quantity;
    }

    public void setQuantity(String quantity) {
        this.quantity = quantity;
    }

    public String getUnit_name() {
        return unit_name;
    }

    public void setUnit_name(String unit_name) {
        this.unit_name = unit_name;
    }

    public String getUnit_price() {
        return unit_price;
    }

    public void setUnit_price(String unit_price) {
        this.unit_price = unit_price;
    }

    public String getVat_rate() {
        return vat_rate;
    }

    public void setVat_rate(String vat_rate) {
        this.vat_rate = vat_rate;
    }

    public String getCustomId() {
        return customId;
    }

    public void setCustomId(String customId) {
        this.customId = customId;
    }
}

