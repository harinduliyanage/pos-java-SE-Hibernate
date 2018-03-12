package com.alpha.dao.custom;

import com.alpha.dao.SuperDAO;
import com.alpha.model.User;
import java.util.List;

public interface UserDAO extends SuperDAO<User> {
    public User getUserByTypeAndPassword(String type , String pass)throws Exception;
    public User searchByUserName(String userName)throws Exception;
    public User authentication(String userType , String userName , String password)throws Exception;
    public List<User> foundByLike(String value)throws Exception;
}
