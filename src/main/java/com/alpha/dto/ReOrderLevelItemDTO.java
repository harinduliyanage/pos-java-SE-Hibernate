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
public class ReOrderLevelItemDTO {
    private int itemId;
    private String description;
    private String packSize;
    private int availabelBatchQty;
    private double stockQty;
    private double reorderLevel;

    /**
     * @return the itemId
     */
    public int getItemId() {
        return itemId;
    }

    /**
     * @param itemId the itemId to set
     */
    public void setItemId(int itemId) {
        this.itemId = itemId;
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
     * @return the availabelBatchQty
     */
    public int getAvailabelBatchQty() {
        return availabelBatchQty;
    }

    /**
     * @param availabelBatchQty the availabelBatchQty to set
     */
    public void setAvailabelBatchQty(int availabelBatchQty) {
        this.availabelBatchQty = availabelBatchQty;
    }

    /**
     * @return the stockQty
     */
    public double getStockQty() {
        return stockQty;
    }

    /**
     * @param stockQty the stockQty to set
     */
    public void setStockQty(double stockQty) {
        this.stockQty = stockQty;
    }

    /**
     * @return the reorderLevel
     */
    public double getReorderLevel() {
        return reorderLevel;
    }

    /**
     * @param reorderLevel the reorderLevel to set
     */
    public void setReorderLevel(double reorderLevel) {
        this.reorderLevel = reorderLevel;
    }
    
}
