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
            new Welcome().setVisible(true);
            //Create Admin User
            UserDTO userDTO = new UserDTO();
            userDTO.setType("Admin");
            userDTO.setPassword("123");
            userDTO.setUserName("harindu.sul");
            userDTO.setName("Harindu Sulochana");
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
