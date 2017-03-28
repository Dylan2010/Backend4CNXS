package com.cnxs.common;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.BeanFactoryAware;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Component;

@Component
public class ApplicationContextHolder implements ApplicationContextAware, BeanFactoryAware {
    
    private static ApplicationContext applicationContext;
    
    private static BeanFactory beanFactory;
    
    private final static ReadWriteLock rwLock = new ReentrantReadWriteLock();
    
    @Override
    public void setBeanFactory(BeanFactory beanFactory) throws BeansException {
        ApplicationContextHolder.beanFactory = beanFactory;
    }

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        ApplicationContextHolder.applicationContext = applicationContext;
    }
    
    public static ApplicationContext getApplicationContext() {
        return applicationContext;
    }
    
    public static BeanFactory getBeanFactory() {
        return beanFactory;
    }
    
    public static <T> T getBean(Class<T> clazz) {
        
        if (clazz == null) {
            return null;
        }
        
        Lock rlock = rwLock.readLock();
        rlock.lock();
        try {
            return beanFactory == null ? null : beanFactory.getBean(clazz);
        } finally {
            rlock.unlock();
        }
    }
    
}
