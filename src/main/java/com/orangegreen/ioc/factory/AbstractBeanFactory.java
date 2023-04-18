package com.orangegreen.ioc.factory;

import com.orangegreen.ioc.bean.BeanDefinition;

import java.util.HashMap;
import java.util.Map;

/**
 * <p>
 *
 * </p>
 *
 * @author wuxj
 * @since 2023/4/14 17:07:47
 */

public abstract class AbstractBeanFactory implements BeanFactory{


    /**
     * 容器
     */
    private Map<String, Object> beanHashMap = new HashMap<String, Object>();


    /**
     * 容器
     */
    private Map<String, BeanDefinition> beanDefinitionHashMap = new HashMap<String, BeanDefinition>();


    @Override
    public Object getBean(String name) throws Exception {

        Object bean = beanHashMap.get(name);

        if (bean == null) {
            BeanDefinition beandefinition = beanDefinitionHashMap.get(name);
            if (beandefinition == null) {
                throw new IllegalArgumentException("Not config Bean named " + name + " data in xml");
            }
            bean = doCreate(beandefinition);
            beanHashMap.put(name, bean);
        }

        return bean;
    }


    @Override
    public void createBeanFromBeanDefinition(String name, BeanDefinition beanDefinition) throws Exception {
        beanDefinitionHashMap.put(name, beanDefinition);
        Object bean = doCreate(beanDefinition);
        beanHashMap.put(name, bean);
    }

//    @Override
//    public void registerBeanDefinitions(Map<String, BeanDefinition> map) throws Exception {
////        beanDefinitionHashMap = map;
////        for (Map.Entry<String, BeanDefinition> bdmap: map.entrySet()) {
////            String beanName = bdmap.getKey();
////            BeanDefinition beanDefinition = bdmap.getValue();
////            System.out.println(" bean name: "+ beanName);
////            Object bean = doCreate(beanDefinition);
////            if (!beanHashMap.containsKey(beanName)) {
////                beanHashMap.put(beanName, bean);
////            }
////        }
//    }

    @Override
    public void createBeansFromBeanDefinitions(Map<String, BeanDefinition> map) throws Exception{
        beanDefinitionHashMap = map;
        for (Map.Entry<String, BeanDefinition> bdmap: map.entrySet()) {
            String beanName = bdmap.getKey();
            BeanDefinition beanDefinition = bdmap.getValue();
            System.out.println(" bean name: "+ beanName);
            Object bean = doCreate(beanDefinition);
            if (!beanHashMap.containsKey(beanName)) {
                beanHashMap.put(beanName, bean);
            }
        }
    }

    /**
     * 创建一个bean
     */
    abstract Object doCreate(BeanDefinition beandefinition) throws Exception;



}
