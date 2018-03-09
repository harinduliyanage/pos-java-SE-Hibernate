package com.alpha.dto;

import com.alpha.model.Orders;
import java.util.List;

/**
 * Created by Harindu.sul on 2/5/2018.
 */
public class UserDTO {
    private int id;
    private String type;
    private String name;
    private String userName;
    private String password;
    private List<Orders> orders ;

    public UserDTO(){

    }


    public UserDTO(String type, String userName, String password) {
        this.type = type;
        this.userName = userName;
        this.password = password;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    /**
     * @return the name
     */
    public String getName() {
        return name;
    }

    /**
     * @param name the name to set
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * @return the orders
     */
    public List<Orders> getOrders() {
        return orders;
    }

    /**
     * @param orders the orders to set
     */
    public void setOrders(List<Orders> orders) {
        this.orders = orders;
    }

}