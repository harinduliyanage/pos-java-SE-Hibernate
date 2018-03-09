/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.alpha.service.custom;

import com.alpha.dto.ItemDTO;
import com.alpha.model.Batch;
import com.alpha.model.Item;
import com.alpha.service.SuperService;
import java.util.List;

/**
 *
 * @author Harindu.sul
 */
public interface ItemService extends SuperService<ItemDTO>{
    public Item getItemByDescription(String description) throws Exception;
    public List<Item> getItemsByDescriptionLike(String value) throws Exception;
    public Item getItemByBarcode(String barcode) throws Exception;
    public List<Batch> getItemsBatchesById(int id) throws Exception;
    
    
}
