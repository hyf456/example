package com.han.example.service.factory;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.FactoryBean;
import org.springframework.beans.factory.ObjectFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Configuration
public class RootConfig {

    @Bean
    public FactoryBean myFactoryBean() {
        return new MyFactoryBean();
    }

    @Bean
    public ObjectFactory myObjectFactory() {
        return new MyObjectFactory();
    }

    public static class MyFactoryBean implements FactoryBean<Daughter> {

        @Override
        public Daughter getObject() throws Exception {
            return new Daughter();
        }

        @Override
        public Class<?> getObjectType() {
            return Daughter.class;
        }
    }

    public static class MyObjectFactory implements ObjectFactory<Son> {

        @Override
        public Son getObject() throws BeansException {
            return new Son();
        }
    }

}
