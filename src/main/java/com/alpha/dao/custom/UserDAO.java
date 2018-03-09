package com.alpha.dao.custom;

import com.alpha.dao.SuperDAO;
import com.alpha.model.User;
import java.util.List;

/**
 * Created by Harindu.sul on 2/5/2018.
 */
public interface UserDAO extends SuperDAO<User> {

    public User searchByUserName(String userName)throws Exception;
    public User authentication(String userType , String userName , String password)throws Exception;
    public List<User> foundByLike(String value)throws Exception;
}
