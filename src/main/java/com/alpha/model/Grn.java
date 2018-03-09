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
import javax.persistence.Table;
import javax.persistence.Transient;
import org.hibernate.annotations.Type;

/**
 *
 * @author Harindu.sul
 */
@Entity
@Table(name = "GRN")
public class Grn {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "GRN_ID")
    private int id;
    private String supplier;
    @Type(type = "org.jadira.usertype.dateandtime.joda.PersistentLocalDate")
    private org.joda.time.LocalDate dates;

    @Transient
    @OneToMany(mappedBy = "Grn", cascade = CascadeType.PERSIST, fetch = FetchType.LAZY, orphanRemoval = true)
    private Set<GrnDetails> grnDetails = new HashSet<GrnDetails>();

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getSupplierName() {
        return supplier;
    }

    public void setSupplierName(String supplierName) {
        this.supplier = supplierName;
    }

    public org.joda.time.LocalDate getDates() {
        return dates;
    }

    public void setDates(org.joda.time.LocalDate dates) {
        this.dates = dates;
    }

    public Set<GrnDetails> getGrnDetails() {
        return grnDetails;
    }

    public void setGrnDetails(Set<GrnDetails> grnDetails) {
        this.grnDetails = grnDetails;
    }

}
