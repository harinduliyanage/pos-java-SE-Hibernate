/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.alpha.model;

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
@Table(name = "GRN_DETAILS")
public class GrnDetails {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "GRN_DETAILS_ID")
    private int Id;
    @ManyToOne(cascade = CascadeType.PERSIST, optional = true, fetch = FetchType.LAZY)
    @JoinColumn(name = "BATCH_ID", nullable = false)
    private Batch batch;
    @ManyToOne(cascade = CascadeType.PERSIST, optional = true, fetch = FetchType.LAZY)
    @JoinColumn(name = "GRN_ID", nullable = false)
    private Grn grn;
    private String description;
    private double qty;

    public int getId() {
        return Id;
    }

    public void setId(int Id) {
        this.Id = Id;
    }

    public Batch getBatch() {
        return batch;
    }

    public void setBatch(Batch batch) {
        this.batch = batch;
    }

    public Grn getGrn() {
        return grn;
    }

    public void setGrn(Grn grn) {
        this.grn = grn;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public double getQty() {
        return qty;
    }

    public void setQty(double qty) {
        this.qty = qty;
    }
}
