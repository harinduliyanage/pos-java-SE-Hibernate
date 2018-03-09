/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.alpha.config;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;

/**
 *
 * @author Harindu.sul
 */
public class Context {
    
    private static Context instance;
    private static AbstractApplicationContext context;
    
    private Context(){
        context=new AnnotationConfigApplicationContext(AppConfig.class);
    }
    
    public static AbstractApplicationContext getInstance(){
        if(instance == null){
            instance = new Context();
        }
        return context;
    }
}
