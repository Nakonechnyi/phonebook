package org.nakonechnyi.config;

import org.springframework.beans.factory.InitializingBean;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;
import org.springframework.security.core.context.SecurityContextHolder;

import java.util.Map;
import java.util.Properties;

/**
 * @autor A_Nakonechnyi
 * @date 27.10.2016.
 */
public class CustomPropertySourcesPlaceholderConfigurer extends PropertySourcesPlaceholderConfigurer implements InitializingBean {

    public void afterPropertiesSet(){
        System.err.println("eee");
        try{
            Properties loadedProperties = this.mergeProperties();
            for(Map.Entry<Object, Object> singleProperty : loadedProperties.entrySet()){
                System.err.println("LoadedProperty: "+singleProperty.getKey()+"="+singleProperty.getValue());
            }

            System.err.println(SecurityContextHolder.getContext().toString());
        }catch(Exception ex){
            ex.printStackTrace();
        }
    }
}
