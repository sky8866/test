package com.antiphon.xiaomai.common.utils;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.BeanFactoryAware;

/**
 * spring获取bean的工具类
 * * 
 * <pre>
 * -------------History------------------
 * DATE        AUTHOR    VERSION        DESCRIPTION
 * 2014年5月4日                     V13.00.001      新增
 *
 *@author 彭锦章 
 */
public class SpringBeanLocator implements BeanFactoryAware {
	
    private static BeanFactory beanFactory = null;
 
    private static SpringBeanLocator locator = null;
 
    public void setBeanFactory(BeanFactory factory) throws BeansException {
        beanFactory = factory;
    }
 
    public BeanFactory getBeanFactory() {
        return beanFactory;
    }
 
   
    public static SpringBeanLocator getInstance() {
        if (locator == null)
              locator = (SpringBeanLocator) beanFactory.getBean("beanLocator");
        return locator;
    }
 
    /**
    * 根据提供的bean名称得到相应的实例     
    * @param beanName bean名称     
    */
    public static Object getBean(String beanName) {
        return beanFactory.getBean(beanName);
    }
 
    /**
    * 根据提供的bean名称得到对应于指定类型的实例
    * @param beanName bean名称
    * @param clazz 返回的bean类型,若类型不匹配,将抛出异常
    */
    @SuppressWarnings("unchecked")
	public static Object getBean(String beanName, Class clazz) {
        return beanFactory.getBean(beanName, clazz);
    }
}