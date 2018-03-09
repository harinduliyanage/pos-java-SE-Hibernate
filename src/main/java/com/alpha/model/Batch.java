/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.alpha.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import org.hibernate.annotations.Type;

/**
 *
 * @author Harindu.sul
 */
@Entity
public class Batch {

    @Id
    @Column(name = "BATCH_ID")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String batch;
    @Type(type = "org.jadira.usertype.dateandtime.joda.PersistentLocalDate")
    private org.joda.time.LocalDate MFD;
    @Type(type = "org.jadira.usertype.dateandtime.joda.PersistentLocalDate")
    private org.joda.time.LocalDate EXPD;
    private double unitPrice;
    private double qtyOnHand;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getBatch() {
        return batch;
    }

    public void setBatch(String batch) {
        this.batch = batch;
    }

    public org.joda.time.LocalDate getMFD() {
        return MFD;
    }

    public void setMFD(org.joda.time.LocalDate MFD) {
        this.MFD = MFD;
    }

    public org.joda.time.LocalDate getEXPD() {
        return EXPD;
    }

    public void setEXPD(org.joda.time.LocalDate EXPD) {
        this.EXPD = EXPD;
    }

    public double getUnitPrice() {
        return unitPrice;
    }

    public void setUnitPrice(double unitPrice) {
        this.unitPrice = unitPrice;
    }

    public double getQtyOnHand() {
        return qtyOnHand;
    }

    public void setQtyOnHand(double qtyOnHand) {
        this.qtyOnHand = qtyOnHand;
    }
}
