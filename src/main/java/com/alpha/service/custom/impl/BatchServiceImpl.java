/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.alpha.service.custom.impl;

import com.alpha.dao.custom.BatchDAO;
import com.alpha.dto.BatchDTO;
import com.alpha.model.Batch;
import com.alpha.service.custom.BatchService;
import java.util.ArrayList;
import java.util.List;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author Harindu.sul
 */
@Service("BatchService")
@Transactional
public class BatchServiceImpl implements BatchService {

    @Autowired
    BatchDAO batchDAO;

    @Override
    public BatchDTO getBatchByBatchName(String batch) throws Exception {
        Batch t = batchDAO.getBatchByBatchName(batch);
        if (t == null) {
            return null;
        } else {
            BatchDTO batchDTO = new BatchDTO();
            batchDTO.setId(t.getId());
            batchDTO.setBatch(t.getBatch());
            batchDTO.setEXPD(t.getEXPD());
            batchDTO.setMFD(t.getMFD());
            batchDTO.setQtyOnHand(t.getQtyOnHand());
            batchDTO.setUnitPrice(t.getUnitPrice());
            return batchDTO;
        }
    }

    @Override
    public boolean add(BatchDTO t) throws Exception {
        Batch batch = new Batch();
        batch.setBatch(t.getBatch());
        batch.setEXPD(t.getEXPD());
        batch.setMFD(t.getMFD());
        batch.setQtyOnHand(t.getQtyOnHand());
        batch.setUnitPrice(t.getUnitPrice());
        return batchDAO.add(batch);
    }

    @Override
    public boolean delete(int id) throws Exception {
        return batchDAO.delete(id);
    }

    @Override
    public boolean update(BatchDTO t) throws Exception {
        Batch batch = new Batch();
        batch.setId(t.getId());
        batch.setBatch(t.getBatch());
        batch.setEXPD(t.getEXPD());
        batch.setMFD(t.getMFD());
        batch.setQtyOnHand(t.getQtyOnHand());
        batch.setUnitPrice(t.getUnitPrice());
        return batchDAO.update(batch);
    }

    @Override
    public BatchDTO search(int id) throws Exception {
        Batch t = batchDAO.search(id);
        if (t == null) {
            return null;
        } else {
            BatchDTO batch = new BatchDTO();
            batch.setId(t.getId());
            batch.setBatch(t.getBatch());
            batch.setEXPD(t.getEXPD());
            batch.setMFD(t.getMFD());
            batch.setQtyOnHand(t.getQtyOnHand());
            batch.setUnitPrice(t.getUnitPrice());
            return batch;
        }
    }

    @Override
    public List<BatchDTO> getAll() throws Exception {
        List<Batch> allBatch = batchDAO.getAll();
        if (allBatch == null) {
            return null;
        } else {
            List<BatchDTO> all = new ArrayList<>();
            for (Batch t : allBatch) {
                BatchDTO batch = new BatchDTO();
                batch.setId(t.getId());
                batch.setBatch(t.getBatch());
                batch.setEXPD(t.getEXPD());
                batch.setMFD(t.getMFD());
                batch.setQtyOnHand(t.getQtyOnHand());
                batch.setUnitPrice(t.getUnitPrice());
                all.add(batch);
            }
            return all;
        }
    }

    @Override
    public BatchDTO getBatchByBatchNameAndItemId(String batch, int itemId) throws Exception {
        Batch t = batchDAO.getBatchByBatchNameAndItemId(batch, itemId);
        if (t == null) {
            return null;
        } else {
            BatchDTO b = new BatchDTO();
            b.setId(t.getId());
            b.setBatch(t.getBatch());
            b.setEXPD(t.getEXPD());
            b.setMFD(t.getMFD());
            b.setQtyOnHand(t.getQtyOnHand());
            b.setUnitPrice(t.getUnitPrice());
            return b;
        }
    }

}
