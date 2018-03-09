/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.alpha.dto;

import com.alpha.model.Batch;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Harindu.sul
 */
public class ItemDTO {
    private int id;
    private String barcode;
    private String description;
    private String packSize;
    private int reOrderLevel;
    private List<Batch> batch;
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
     * @return the barcode
     */
    public String getBarcode() {
        return barcode;
    }

    /**
     * @param barcode the barcode to set
     */
    public void setBarcode(String barcode) {
        this.barcode = barcode;
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
     * @return the packSize
     */
    public String getPackSize() {
        return packSize;
    }

    /**
     * @param packSize the packSize to set
     */
    public void setPackSize(String packSize) {
        this.packSize = packSize;
    }

    /**
     * @return the reOrderLevel
     */
    public int getReOrderLevel() {
        return reOrderLevel;
    }

    /**
     * @param reOrderLevel the reOrderLevel to set
     */
    public void setReOrderLevel(int reOrderLevel) {
        this.reOrderLevel = reOrderLevel;
    }

    public List<Batch> getBatch() {
        return batch;
    }

   
    public void setBatch(List<Batch> batch) {
        this.batch = batch;
    }

}
