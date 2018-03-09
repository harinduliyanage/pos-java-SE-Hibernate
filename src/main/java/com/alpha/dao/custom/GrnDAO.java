/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.alpha.dao.custom;

import com.alpha.dao.SuperDAO;
import com.alpha.model.Grn;

/**
 *
 * @author Harindu.sul
 */
public interface GrnDAO extends SuperDAO<Grn>{
    public int getAddedGRNID()throws Exception;
    public int addGrn(Grn t)throws Exception;
}
