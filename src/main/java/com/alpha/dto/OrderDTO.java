/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.alpha.dto;

import com.alpha.model.OrderDetails;
import java.util.HashSet;
import java.util.Set;

/**
 *
 * @author Harindu.sul
 */
public class OrderDTO {

    private int id;
    private org.joda.time.LocalDate date;
    private String time;
    private double total;
    private double discounts;
    private double subTot;
    private Set<OrderDetails> orderDetails = new HashSet<OrderDetails>();
    private int cashierId;

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
     * @return the date
     */
    public org.joda.time.LocalDate getDate() {
        return date;
    }

    /**
     * @param date the date to set
     */
    public void setDate(org.joda.time.LocalDate date) {
        this.date = date;
    }

    /**
     * @return the time
     */
    public String getTime() {
        return time;
    }

    /**
     * @param time the time to set
     */
    public void setTime(String time) {
        this.time = time;
    }

    /**
     * @return the total
     */
    public double getTotal() {
        return total;
    }

    /**
     * @param total the total to set
     */
    public void setTotal(double total) {
        this.total = total;
    }

    /**
     * @return the subTot
     */
    public double getSubTot() {
        return subTot;
    }

    /**
     * @param subTot the subTot to set
     */
    public void setSubTot(double subTot) {
        this.subTot = subTot;
    }

    /**
     * @return the orderDetails
     */
    public Set<OrderDetails> getOrderDetails() {
        return orderDetails;
    }

    /**
     * @param orderDetails the orderDetails to set
     */
    public void setOrderDetails(Set<OrderDetails> orderDetails) {
        this.orderDetails = orderDetails;
    }

    /**
     * @return the discounts
     */
    public double getDiscounts() {
        return discounts;
    }

    /**
     * @param discounts the discounts to set
     */
    public void setDiscounts(double discounts) {
        this.discounts = discounts;
    }

    /**
     * @return the cashierId
     */
    public int getCashierId() {
        return cashierId;
    }

    /**
     * @param cashierId the cashierId to set
     */
    public void setCashierId(int cashierId) {
        this.cashierId = cashierId;
    }
}
