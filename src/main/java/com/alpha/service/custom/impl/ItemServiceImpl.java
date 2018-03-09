/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.alpha.service.custom.impl;

import com.alpha.dao.custom.ItemDAO;
import com.alpha.dto.ItemDTO;
import com.alpha.model.Batch;
import com.alpha.model.Item;
import com.alpha.service.custom.ItemService;
import java.util.ArrayList;
import java.util.List;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author Harindu.sul
 */
@Service("ItemService")
@Transactional
public class ItemServiceImpl implements ItemService {

    @Autowired
    private ItemDAO itemDAO;

    @Override
    public Item getItemByDescription(String description) throws Exception {
        return itemDAO.getItemByDescription(description);
    }

    @Override
    public Item getItemByBarcode(String barcode) throws Exception {
        return itemDAO.getItemByBarcode(barcode);
    }

    @Override
    public boolean add(ItemDTO t) throws Exception {
        Item i = new Item();
        i.setBarcode(t.getBarcode());
        i.setDescription(t.getDescription());
        i.setPackSize(t.getPackSize());
        i.setReOrderLevel(t.getReOrderLevel());
        i.setBatch(t.getBatch());
        return itemDAO.add(i);
    }

    @Override
    public boolean delete(int id) throws Exception {
        return itemDAO.delete(id);
    }

    @Override
    public boolean update(ItemDTO t) throws Exception {
        Item i = new Item();
        i.setId(t.getId());
        i.setBarcode(t.getBarcode());
        i.setDescription(t.getDescription());
        i.setPackSize(t.getPackSize());
        i.setReOrderLevel(t.getReOrderLevel());
        i.setBatch(t.getBatch());
        return itemDAO.update(i);
    }

    @Override
    public ItemDTO search(int id) throws Exception {
        Item t = itemDAO.search(id);
        ItemDTO i = new ItemDTO();
        i.setId(t.getId());
        i.setBarcode(t.getBarcode());
        i.setDescription(t.getDescription());
        i.setPackSize(t.getPackSize());
        i.setReOrderLevel(t.getReOrderLevel());
        i.setBatch(t.getBatch());
        return i;
    }

    @Override
    public List<ItemDTO> getAll() throws Exception {
        List<Item> all = itemDAO.getAll();
        List<ItemDTO> allItems=new ArrayList<>();
        if(all!=null){
            for (Item t : all) {
                ItemDTO i = new ItemDTO();
                i.setId(t.getId());
                i.setBarcode(t.getBarcode());
                i.setDescription(t.getDescription());
                i.setPackSize(t.getPackSize());
                i.setReOrderLevel(t.getReOrderLevel());
                i.setBatch(t.getBatch());
                allItems.add(i);
            }
            return allItems;
        }else{
            return null;
        }
    }

    @Override
    public List<Batch> getItemsBatchesById(int id) throws Exception {
        return itemDAO.getItemsBatchesById(id);
    }

    @Override
    public List<Item> getItemsByDescriptionLike(String value) throws Exception {
        return itemDAO.getItemsByDescriptionLike(value);
    }

}
