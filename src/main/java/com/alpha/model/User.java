package com.alpha.model;

import java.util.ArrayList;
import java.util.List;
import javax.persistence.*;

/**
 * Created by Harindu.sul on 2/5/2018.
 */
@Entity
@Table(name = "USER")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String type;
    private String name;
    private String userName;
    private String password;
    @OneToMany(cascade = CascadeType.ALL,orphanRemoval = false, fetch = FetchType.LAZY)
    @JoinColumn(name = "User_id")
    private List<Orders> orders ;

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
     * @return the Name
     */
    public String getName() {
        return name;
    }

    /**
     * @param Name the Name to set
     */
    public void setName(String Name) {
        this.name = Name;
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
