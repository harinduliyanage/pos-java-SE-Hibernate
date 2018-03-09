/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.alpha.dto;

import java.util.HashSet;
import java.util.Set;

/**
 *
 * @author Harindu.sul
 */
public class GrnDTO {
    private int id;
    private String supplier;
    private org.joda.time.LocalDate dates;
    private Set<GrnDetailsDTO> grnDetails = new HashSet<GrnDetailsDTO>();

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
     * @return the supplier
     */
    public String getSupplier() {
        return supplier;
    }

    /**
     * @param supplier the supplier to set
     */
    public void setSupplier(String supplier) {
        this.supplier = supplier;
    }

    /**
     * @return the dates
     */
    public org.joda.time.LocalDate getDates() {
        return dates;
    }

    /**
     * @param dates the dates to set
     */
    public void setDates(org.joda.time.LocalDate dates) {
        this.dates = dates;
    }

    /**
     * @return the grnDetails
     */
    public Set<GrnDetailsDTO> getGrnDetails() {
        return grnDetails;
    }

    /**
     * @param grnDetails the grnDetails to set
     */
    public void setGrnDetails(Set<GrnDetailsDTO> grnDetails) {
        this.grnDetails = grnDetails;
    }
}
