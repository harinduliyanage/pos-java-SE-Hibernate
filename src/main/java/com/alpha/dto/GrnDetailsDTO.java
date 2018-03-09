/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.alpha.dto;

import com.alpha.model.Batch;
import com.alpha.model.Grn;

/**
 *
 * @author Harindu.sul
 */
public class GrnDetailsDTO {
    private int id;
    private BatchDTO batch;
    private Grn grn;
    private String description;
    private double qty;

    public GrnDetailsDTO(){
        
    }
    
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
    public BatchDTO getBatch() {
        return batch;
    }

    /**
     * @param batch the batch to set
     */
    public void setBatch(BatchDTO batch) {
        this.batch = batch;
    }

    /**
     * @return the grn
     */
    public Grn getGrn() {
        return grn;
    }

    /**
     * @param grn the grn to set
     */
    public void setGrn(Grn grn) {
        this.grn = grn;
    }

    /**
     * @return the description
     */
    public String getDescription() {
        return description;
    }

    /**
     * @param description the description to set
     */
    public void setDescription(String description) {
        this.description = description;
    }

    /**
     * @return the qty
     */
    public double getQty() {
        return qty;
    }

    /**
     * @param qty the qty to set
     */
    public void setQty(double qty) {
        this.qty = qty;
    }
}
