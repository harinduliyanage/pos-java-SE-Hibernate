/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.alpha.service;

import java.util.List;

 
public interface SuperService <T> {
    public boolean add(T t)throws Exception;
    public boolean delete(int id)throws Exception;
    public boolean update(T t)throws Exception;
    public T search(int id)throws Exception;
    public List<T> getAll()throws Exception;
}