package com.alpha.dao;

import java.util.List;

/**
 * Created by Harindu.sul on 2/5/2018.
 */
public interface SuperDAO <T> {
    public boolean add(T t)throws Exception;
    public boolean delete(int id)throws Exception;
    public boolean update(T t)throws Exception;
    public T search(int id)throws Exception;
    public List<T> getAll()throws Exception;
}
