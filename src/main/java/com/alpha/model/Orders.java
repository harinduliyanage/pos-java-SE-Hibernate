/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.alpha.model;

import java.util.HashSet;
import java.util.Set;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Transient;
import org.hibernate.annotations.Type;

/**
 *
 * @author Harindu.sul
 */
@Entity(name = "Orders")
public class Orders {
    @Id
    @Column(name = "ORDER_ID")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    
    @Column(name = "dates", nullable = false)
    @Type(type = "org.jadira.usertype.dateandtime.joda.PersistentLocalDate")
    private org.joda.time.LocalDate date;
    private String time;
    private double total;
    private double subTot;
    private double discounts;
    @Transient
    @OneToMany(mappedBy = "Orders", cascade = CascadeType.PERSIST, fetch = FetchType.LAZY, orphanRemoval = true)
    private Set<OrderDetails> orderDetails = new HashSet<OrderDetails>();
        
    public int getId() {
        return id;
    }

  
    public void setId(int id) {
        this.id = id;
    }

  
    public org.joda.time.LocalDate getDate() {
        return date;
    }

    
    public void setDate(org.joda.time.LocalDate date) {
        this.date = date;
    }

   
    public String getTime() {
        return time;
    }
 
    public void setTime(String time) {
        this.time = time;
    }
 
    public double getTotal() {
        return total;
    }

   
    public void setTotal(double total) {
        this.total = total;
    }
 
    public double getSubTot() {
        return subTot;
    }

 
    public void setSubTot(double subTot) {
        this.subTot = subTot;
    }

  
    public Set<OrderDetails> getOrderDetails() {
        return orderDetails;
    }

    
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
 
    

}