package com.orangegreen.ioc.factory;

import com.orangegreen.ioc.bean.BeanDefinition;
import com.orangegreen.ioc.bean.BeanReference;
import com.orangegreen.ioc.bean.PropertyValue;

import java.lang.reflect.Field;

/**
 * <p>
 *
 * </p>
 *
 * @author wuxj
 * @since 2023/4/14 17:16:14
 */

public class AutowireBeanFactory extends AbstractBeanFactory{
    /**
     * 根据bean 定义创建实例， 并将实例作为key， bean定义作为value存放，
     * 并调用 addPropertyValue 方法 为给定的bean的属性进行注入
     */

    @Override
    Object doCreate(BeanDefinition beandefinition) throws Exception {
        // 获取一个bean的 Class对象， 通过Class反射构造方法生成一个bean实例
        Object bean = beandefinition.getBeanclass().getDeclaredConstructor().newInstance();

        // 给bean实例的各个属性赋值
        addPropertyValue(bean, beandefinition);
        return bean;
    }

    /**
     * 给定一个bean定义和一个bean实例，为给定的bean中的属性注入实例。
     */
    private void addPropertyValue(Object bean, BeanDefinition beandefinition) throws Exception {
        for (PropertyValue pv: beandefinition.getPropertyValues().getPropertyValues()) {
            // 根据给定属性名称获取bean的属性对象(declaredField对象)
            Field declaredField = bean.getClass().getDeclaredField(pv.getName());
            // 设置属性的访问权限
            declaredField.setAccessible(true);
            // 获取定义的属性中的对象
            Object value = pv.getValue();

            // 判断这个对象是否是 Bean引用对象(BeanReference)， 即它引用了另外一个bean
            if (value instanceof BeanReference ) {
                // 将属性对象转为 BeanReference 对象
                BeanReference beanReference = (BeanReference) value;

                // 调用父类的 AbstractBeanFactory 的 getBean 方法，
                // 根据bean引用的名称获取实例，此处即是递归
                value = getBean(beanReference.getName());

            }

            // 反射注入bean的属性
            declaredField.set(bean, value);

        }

    }

}
