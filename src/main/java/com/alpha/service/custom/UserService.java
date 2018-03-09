/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.alpha.service.custom;

import com.alpha.dto.UserDTO;
import com.alpha.model.User;
import com.alpha.service.SuperService;
import java.util.List;

/**
 *
 * @author Harindu.sul
 */
public interface UserService extends SuperService<UserDTO>{

    public UserDTO searchByUserName(String userName)throws Exception;
    public UserDTO authentication(String userType, String userName, String password) throws Exception; 
    public List<User> foundByLike(String value) throws Exception;
}
