package com.orangegreen.ioc.bean;

/**
 *  BeanDefinition类型, 记录一些bean的元数据，像类名、属性、方法等
 *  为了考虑扩展可以定义为BeanDefinition为接口，这里为了最简单的实现功能就定义成了类
 */

public class BeanDefinition {
    /**
     * bean 的 CLass 对象
     */
    private Class beanClass;

    /**
     * bean 的类全限定名称
     */
    private String ClassName;

    /**
     * 类的属性集合
     */
    private PropertyValues propertyValues = new PropertyValues();

    /**
     * 获取bean的Class对象
     */
    public Class getBeanclass() {
        return this.beanClass;
    }

    /**
     * 通过设置类名称反射生成Class对象
     */
    public void setClassname(String name) {
        this.ClassName = name;
        try {
            this.beanClass = Class.forName(name);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    /**
     * 获取bean的属性集合
     */
    public PropertyValues getPropertyValues() {
        return this.propertyValues;
    }

    /**
     * 设置bean的属性
     */
    public void setPropertyValues(PropertyValues pv) {
        this.propertyValues = pv;
    }
}

