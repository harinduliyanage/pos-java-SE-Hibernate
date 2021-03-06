/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.alpha.service.custom;

import com.alpha.dto.BatchDTO;
import com.alpha.dto.ReOrderLevelItemDTO;
import com.alpha.service.SuperService;
import java.util.List;

/**
 *
 * @author Harindu.sul
 */

public interface BatchService extends SuperService<BatchDTO>{
    public BatchDTO getBatchByBatchName(String batch) throws Exception;
    public BatchDTO getBatchByBatchNameAndItemId(String batch,int itemId) throws Exception;
    public List<ReOrderLevelItemDTO> getReOrderLevelItems() throws Exception;
    
}
