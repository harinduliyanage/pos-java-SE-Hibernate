/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.alpha.dao.custom;

import com.alpha.dao.SuperDAO;
import com.alpha.model.Batch;
import com.alpha.model.Item;
import java.util.List;

/**
 *
 * @author Harindu.sul
 */
public interface ItemDAO extends SuperDAO<Item>{
    public Item getItemByDescription(String description) throws Exception;
    public List<Item> getItemsByDescriptionLike(String value) throws Exception; 
    public Item getItemByBarcode(String barcode) throws Exception;
    public List<Batch> getItemsBatchesById(int id) throws Exception;
}
