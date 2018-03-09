/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.alpha.service.custom.impl;

import com.alpha.dao.custom.BatchDAO;
import com.alpha.dao.custom.GrnDAO;
import com.alpha.dao.custom.GrnDetailsDAO;
import com.alpha.dto.GrnDTO;
import com.alpha.dto.GrnDetailsDTO;
import com.alpha.model.Batch;
import com.alpha.model.Grn;
import com.alpha.model.GrnDetails;
import com.alpha.service.custom.GrnService;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author Harindu.sul
 */
@Service("GrnService")
@Transactional
public class GrnServiceImpl implements GrnService {
    
    @Autowired
    private GrnDAO grnDAO;
    
    @Autowired
    private GrnDetailsDAO grnDetailsDAO;
    
    @Autowired 
    private BatchDAO batchDAO;

    @Override
    @Transactional
    public boolean add(GrnDTO t) throws Exception {
        Set<GrnDetailsDTO> all = t.getGrnDetails();
        Set<GrnDetails> allSend = new HashSet<GrnDetails>();
        Grn grn = new Grn();
        grn.setDates(t.getDates());
        grn.setSupplierName(t.getSupplier());
        int getid = grnDAO.addGrn(grn);
        if (getid!=-1) {
            Grn search = grnDAO.search(getid);
            int size = all.size();
            int count=0;
            for (GrnDetailsDTO g : all) {
                count++;
                GrnDetails grnDetails = new GrnDetails();
                Batch batch = new Batch();
                batch.setId(g.getBatch().getId());
                batch.setBatch(g.getBatch().getBatch());
                batch.setEXPD(g.getBatch().getEXPD());
                batch.setMFD(g.getBatch().getMFD());
                double qtyOnHand = g.getBatch().getQtyOnHand();
                double qty = g.getQty();
                double result=qtyOnHand+qty;
                batch.setQtyOnHand(result);
                batch.setUnitPrice(g.getBatch().getUnitPrice());
                batchDAO.update(batch);
                grnDetails.setBatch(batch);
                grnDetails.setGrn(search);
                grnDetails.setDescription(g.getDescription());
                grnDetails.setQty(g.getQty());
                grnDetailsDAO.add(grnDetails);
            }
            if(size==count){
                return true;
            }else{
                return false;
            }
        } else {
            return false;
        }
    }
    
    @Override
    public boolean delete(int id) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    @Override
    public boolean update(GrnDTO t) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    @Override
    public GrnDTO search(int id) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    @Override
    public List<GrnDTO> getAll() throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
