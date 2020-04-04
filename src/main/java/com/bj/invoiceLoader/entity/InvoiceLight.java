package com.bj.invoiceLoader.entity;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import java.util.List;

@Entity
public class InvoiceLight {
    @Id
    private String custom_id;
    private Integer id;    //identifikátor faktury	integer, readonly
    private Integer subject_id;//	ID kontaktu (povinné)	integer, required


    @OneToMany
    private List<Line> lines;

    public InvoiceLight() {
    }

    public InvoiceLight(String custom_id, Integer id, Integer subject_id, List<Line> lines) {
        this.custom_id = custom_id;
        this.id = id;
        this.subject_id = subject_id;
        this.lines = lines;
    }

    public String getCustom_id() {
        return custom_id;
    }

    public void setCustom_id(String custom_id) {
        this.custom_id = custom_id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getSubject_id() {
        return subject_id;
    }

    public void setSubject_id(Integer subject_id) {
        this.subject_id = subject_id;
    }

    public List<Line> getLines() {
        return lines;
    }

    public void setLines(List<Line> lines) {
        this.lines = lines;
    }
}

