/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.alpha.dao.custom;

import com.alpha.dao.SuperDAO;
import com.alpha.model.Batch;

/**
 *
 * @author Harindu.sul
 */
public interface BatchDAO extends SuperDAO<Batch>{
    public Batch getBatchByBatchName(String batch) throws Exception;
    public Batch getBatchByBatchNameAndItemId(String batch,int itemId) throws Exception;
}
