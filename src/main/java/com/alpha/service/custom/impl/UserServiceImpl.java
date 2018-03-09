/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.alpha.service.custom.impl;

import com.alpha.dao.custom.UserDAO;
import com.alpha.dto.UserDTO;
import com.alpha.model.User;
import com.alpha.service.custom.UserService;
import java.util.ArrayList;
import java.util.List;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author Harindu.sul
 */
@Service(value = "UserService")
@Transactional
public class UserServiceImpl implements UserService {

    @Autowired
    UserDAO userDAO;

    @Override
    public boolean add(UserDTO t) throws Exception {
        User user = new User();
        user.setUserName(t.getUserName());
        user.setType(t.getType());
        user.setPassword(t.getPassword());
        user.setName(t.getName());
        User searchByUserName = userDAO.searchByUserName(t.getUserName());
        if (searchByUserName != null) {
            return false;
        }
        return userDAO.add(user);
    }

    @Override
    public boolean delete(int id) throws Exception {
        return userDAO.delete(id);
    }

    @Override
    public boolean update(UserDTO t) throws Exception {
        User u = new User();
        u.setId(t.getId());
        u.setName(t.getName());
        u.setPassword(t.getPassword());
        u.setType(t.getType());
        u.setOrders(t.getOrders());
        u.setUserName(t.getUserName());
        return userDAO.update(u);
    }

    @Override
    public UserDTO search(int id) throws Exception {
        User t = userDAO.search(id);
        UserDTO u = new UserDTO();
        if (t != null) {
            u.setId(t.getId());
            u.setName(t.getName());
            u.setPassword(t.getPassword());
            u.setType(t.getType());
            u.setOrders(t.getOrders());
            u.setUserName(t.getUserName());
            return u;
        } else {
            return null;
        }
    }

    @Override
    public List<UserDTO> getAll() throws Exception {
        List<User> all = userDAO.getAll();
        
        List<UserDTO> allUsers=new ArrayList<>();
        if (all != null) {
            for (User t : all) {
                UserDTO u = new UserDTO();
                u.setId(t.getId());
                u.setName(t.getName());
                u.setPassword(t.getPassword());
                u.setType(t.getType());
                u.setOrders(t.getOrders());
                u.setUserName(t.getUserName());
                allUsers.add(u);
                u=null;
            }
            return allUsers;
        }else{
            return null;
        }
    }

    @Override
    public UserDTO searchByUserName(String userName) throws Exception {
        User searchByUserName = userDAO.searchByUserName(userName);
        if (searchByUserName == null) {
            return null;
        } else {
            UserDTO userDTO = new UserDTO();
            userDTO.setId(searchByUserName.getId());
            userDTO.setName(searchByUserName.getName());
            userDTO.setUserName(searchByUserName.getUserName());
            userDTO.setPassword(searchByUserName.getPassword());
            userDTO.setType(searchByUserName.getType());
            userDTO.setOrders(searchByUserName.getOrders());
            return userDTO;
        }
    }

    @Override
    public UserDTO authentication(String userType, String userName, String password) throws Exception {
        User auth = userDAO.authentication(userType, userName, password);
        if (auth != null) {
            UserDTO userDTO = new UserDTO();
            userDTO.setId(auth.getId());
            userDTO.setName(auth.getName());
            userDTO.setType(auth.getType());
            userDTO.setPassword(auth.getPassword());
            return userDTO;
        }else{
            return null;
        }
    }

    @Override
    public List<User> foundByLike(String value) throws Exception {
        return userDAO.foundByLike(value);
    }

}
