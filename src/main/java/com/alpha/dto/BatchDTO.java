/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.alpha.dto;

/**
 *
 * @author Harindu.sul
 */
public class BatchDTO {
    private int id;
    private String batch;
    private org.joda.time.LocalDate MFD;
    private org.joda.time.LocalDate EXPD;
    private double unitPrice;
    private double qtyOnHand;

    /**
     * @return the id
     */
    public int getId() {
        return id;
    }

    /**
     * @param id the id to set
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * @return the batch
     */
    public String getBatch() {
        return batch;
    }

    /**
     * @param batch the batch to set
     */
    public void setBatch(String batch) {
        this.batch = batch;
    }

    /**
     * @return the MFD
     */
    public org.joda.time.LocalDate getMFD() {
        return MFD;
    }

    /**
     * @param MFD the MFD to set
     */
    public void setMFD(org.joda.time.LocalDate MFD) {
        this.MFD = MFD;
    }

    /**
     * @return the EXPD
     */
    public org.joda.time.LocalDate getEXPD() {
        return EXPD;
    }

    /**
     * @param EXPD the EXPD to set
     */
    public void setEXPD(org.joda.time.LocalDate EXPD) {
        this.EXPD = EXPD;
    }

    /**
     * @return the unitPrice
     */
    public double getUnitPrice() {
        return unitPrice;
    }

    /**
     * @param unitPrice the unitPrice to set
     */
    public void setUnitPrice(double unitPrice) {
        this.unitPrice = unitPrice;
    }

    /**
     * @return the qtyOnHand
     */
    public double getQtyOnHand() {
        return qtyOnHand;
    }

    /**
     * @param qtyOnHand the qtyOnHand to set
     */
    public void setQtyOnHand(double qtyOnHand) {
        this.qtyOnHand = qtyOnHand;
    }
    
}
