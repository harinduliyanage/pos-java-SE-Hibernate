/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.alpha.model;

import java.io.Serializable;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 *
 * @author Harindu.sul
 */
@Entity
@Table(name = "ORDER_DETAILS")
public class OrderDetails implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ORDER_DETAILS_ID")
    private int id;

    @ManyToOne(cascade = CascadeType.ALL, optional = true, fetch = FetchType.LAZY)
    @JoinColumn(name = "ORDER_ID", nullable = false)
    private Orders orders;
    @ManyToOne(cascade = CascadeType.PERSIST, optional = true, fetch = FetchType.LAZY)
    @JoinColumn(name = "BATCH_ID", nullable = false)
    private Batch batch;
    private String description;
    private String packSize;
    private double unitPrice;
    private double orderOTY;
    private double discount;
    private double comDiscount;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Orders getOrders() {
        return orders;
    }

    public void setOrders(Orders orders) {
        this.orders = orders;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getPackSize() {
        return packSize;
    }

    public void setPackSize(String packSize) {
        this.packSize = packSize;
    }

    public double getUnitPrice() {
        return unitPrice;
    }

    public void setUnitPrice(double unitPrice) {
        this.unitPrice = unitPrice;
    }

    public double getDiscount() {
        return discount;
    }

    public void setDiscount(double discount) {
        this.discount = discount;
    }

    public double getComDiscount() {
        return comDiscount;
    }

    public void setComDiscount(double comDiscount) {
        this.comDiscount = comDiscount;
    }

    /**
     * @return the orderOTY
     */
    public double getOrderOTY() {
        return orderOTY;
    }

    /**
     * @param orderOTY the orderOTY to set
     */
    public void setOrderOTY(double orderOTY) {
        this.orderOTY = orderOTY;
    }

    /**
     * @return the batch
     */
    public Batch getBatch() {
        return batch;
    }

    /**
     * @param batch the batch to set
     */
    public void setBatch(Batch batch) {
        this.batch = batch;
    }

}
