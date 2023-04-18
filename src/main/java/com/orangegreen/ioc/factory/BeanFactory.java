package com.orangegreen.ioc.factory;

import com.orangegreen.ioc.bean.BeanDefinition;

import java.util.Map;

/**
 * <p> BeanFactory接口, 定义一些获取bean名称和注册bean的方法</p>
 * * @param null:
 * @return * @return: null
 * @author wuxj
 * @since 2023/4/14 15:19
 */
public interface BeanFactory {
    /**
     * <p> 根据bean name 获取bean  </p>
     * * @param name:
     * @return java.lang.Object
     */
    Object getBean(String name) throws Exception;

    /**
     * <p> 注册bean对象到ioc容器中 </p>
     * * @param name:
     * @param bean:
     */

//    void registerBeanDefinition(String name, BeanDefinition beanDefinition) throws Exception;
//
//
//    void registerBeanDefinitions(Map<String, BeanDefinition> map) throws Exception;

    void createBeanFromBeanDefinition(String name, BeanDefinition beanDefinition) throws Exception;

    void createBeansFromBeanDefinitions(Map<String, BeanDefinition> map) throws Exception;
}
