/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.alpha.main;

import com.alpha.config.Context;
import com.alpha.dto.UserDTO;
import com.alpha.service.custom.BatchService;
import com.alpha.service.custom.ItemService;
import com.alpha.service.custom.OrderService;
import com.alpha.service.custom.UserService;
import com.alpha.view.Welcome;
import java.util.HashMap;
import java.util.Set;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import org.springframework.context.support.AbstractApplicationContext;

/**
 *
 * @author Harindu.sul
 */
public class Main {

    public static void main(String[] args) {

        AbstractApplicationContext context = Context.getInstance();
        try {
            UserService userService = (UserService) context.getBean("UserService");
            ItemService itemService = (ItemService) context.getBean("ItemService");
            BatchService batchService = (BatchService) context.getBean("BatchService");
            OrderService orderService = (OrderService) context.getBean("OrderService");
            new Welcome().setVisible(true);
              //Create User
            UserDTO userDTO = new UserDTO();
            userDTO.setType("Admin");
            userDTO.setPassword("123");
            userDTO.setUserName("harindu.sul");
            userDTO.setName("Harindu Sulochana");
            System.out.println("*****************");
            HashMap<String, Double> passMoveItems = orderService.getPassMoveItems();
            Set<String> keySet = passMoveItems.keySet();
            for (String string : keySet) {
                System.out.println("Key--"+string);
                System.out.println("Val--"+passMoveItems.get(string));
                
            }
            System.out.println("*****************");
            boolean add = userService.add(userDTO);
            if (add) {
                System.out.println("User Added Succefully...");

            } else {
                System.out.println("User Added Fail..");
            }
            
           
        } catch (Exception ex) {
            Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(null, ex.getMessage());
        
    }

    }
}
/*

//          //+++++++++++++++++ User For create User Account+++++++++++++++++++++++++// 
//            
//            //Create User
//            UserDTO userDTO = new UserDTO();
//            userDTO.setType("Cashier");
//            userDTO.setPassword("123");
//            userDTO.setUserName("harindu.sul");
//            userDTO.setName("Harindu Sulochana");
//
//            boolean add = userService.add(userDTO);
//            if (add) {
//                System.out.println("User Added Succefully...");
//
//            } else {
//                System.out.println("User Added Fail..");
//            }

            //+++++++++++++++++ User For create Order+++++++++++++++++++++++++//
            //Get Cashier by id or userName
            UserDTO searchByUserName = userService.searchByUserName("harindu.sul");
            if (searchByUserName==null) {
                System.out.println("Searching null");
            }
            
            List<Orders> orders = searchByUserName.getOrders();
            if (orders==null) {
                System.out.println("Orders null");
            }
            if (orders == null) {
                orders = new ArrayList<>();

               
            }
                //Create new Order
                Orders newOrder = new Orders();
                //set date and time
                org.joda.time.LocalDate localDate = org.joda.time.LocalDate.now();
                DateFormat dateFormat = new SimpleDateFormat("HH:mm:ss");
                Date date = new Date();
                newOrder.setTime(dateFormat.format(date));
                newOrder.setDate(localDate);
                newOrder.setTotStoreDis(0.00);
                newOrder.setTotCompanyDis(0.00);
                newOrder.setTotal(550.00);
                newOrder.setSubTot(550.00);

                orders.add(newOrder);

                searchByUserName.setOrders(orders);

            boolean update = userService.update(searchByUserName);
            if (update) {
                System.out.println("Updated//");
            }

 */



/* Item Area 

 //+++++++++++++++ Create new Item++++++++++++++//
            ItemDTO itemDTO = new ItemDTO();
            itemDTO.setBarcode("Ad54887");
            itemDTO.setDescription("Tikiri Mari");
            itemDTO.setPackSize("100g");
            itemDTO.setReOrderLevel(400);
            //+++++++++++++++ Create new Batch++++++++++++++//
            
            //batch for MFD and EXP
            LocalDate MFD = new LocalDate("2010-04-28");
            LocalDate EXP = new LocalDate("2010-04-28");
            
            Batch batch = new Batch();
            batch.setBatch("39");
            batch.setEXPD(EXP);
            batch.setMFD(MFD);
            batch.setQtyOnHand(100.00);
            batch.setUnitPrice(45.00);
            
            itemService.add(itemDTO); 
            //get Item by description
            Item itemByDescription = itemService.getItemByDescription("Tikiri Mari");
            List<Batch> allBatch = itemByDescription.getBatch();
            if(allBatch == null){
                allBatch=new ArrayList<>();
            }
            allBatch.add(batch);
            itemByDescription.setBatch(allBatch);
            //item for batch added then update item
            ItemDTO itemDTO1 = new ItemDTO();
            itemDTO1.setBarcode(itemByDescription.getBarcode());
            itemDTO1.setBatch(itemByDescription.getBatch());
            itemDTO1.setDescription(itemByDescription.getDescription());
            itemDTO1.setId(itemByDescription.getId());
            itemDTO1.setPackSize(itemByDescription.getPackSize());
            itemDTO1.setReOrderLevel(itemByDescription.getReOrderLevel());
            boolean update = itemService.update(itemDTO1);





++++++++++++++++++++++++++++++++++++++++++++Only batch adding+++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
+++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
            //batch for MFD and EXP
            LocalDate MFD = new LocalDate("2010-03-28");
            LocalDate EXP = new LocalDate("2010-10-28");
            
            Batch batch = new Batch();
            batch.setBatch("35");
            batch.setEXPD(EXP);
            batch.setMFD(MFD);
            batch.setQtyOnHand(120.00);
            batch.setUnitPrice(44.00);
            
           
            //get Item by description
            Item itemByDescription = itemService.getItemByDescription("Tikiri Mari");
            List<Batch> allBatch = itemByDescription.getBatch();
            if(allBatch == null){
                allBatch=new ArrayList<>();
            }
            allBatch.add(batch);
            itemByDescription.setBatch(allBatch);
            //item for batch added then update item
            ItemDTO itemDTO1 = new ItemDTO();
            itemDTO1.setBarcode(itemByDescription.getBarcode());
            itemDTO1.setBatch(itemByDescription.getBatch());
            itemDTO1.setDescription(itemByDescription.getDescription());
            itemDTO1.setId(itemByDescription.getId());
            itemDTO1.setPackSize(itemByDescription.getPackSize());
            itemDTO1.setReOrderLevel(itemByDescription.getReOrderLevel());
            boolean update = itemService.update(itemDTO1);

+++++++++++++++++++++++++++++++++++++++batch update+++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++


            BatchDTO batch = batchService.getBatchByBatchNameAndItemId("35", 1);
            batch.setQtyOnHand(35);
            batchService.update(batch);

+++++++++++++++++++++++++++++++++++++++++++++++batch delete++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
            

            BatchDTO batch = batchService.getBatchByBatchNameAndItemId("35", 1);
            batchService.delete(batch.getId());

*/
