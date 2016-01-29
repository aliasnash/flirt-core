package com.fl.core.utilz;

import org.springframework.beans.factory.FactoryBean;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.stereotype.Component;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

@Component("gson")
public class GsonFactoryBean implements FactoryBean<Gson>, InitializingBean {
    
    private GsonBuilder gsonBuilder;
    private Gson        gson;
    
    @Override
    public void afterPropertiesSet() throws Exception {
        if (this.gson == null) {
            if (this.gsonBuilder == null) {
                this.gsonBuilder = new GsonBuilder();
            }
            this.gsonBuilder.setDateFormat("yyyy-MM-dd HH:mm:ss");
            this.gson = this.gsonBuilder.create();
        }
    }
    
    @Override
    public Gson getObject() throws Exception {
        return gson;
    }
    
    @Override
    public Class<?> getObjectType() {
        return Gson.class;
    }
    
    @Override
    public boolean isSingleton() {
        return true;
    }
}
