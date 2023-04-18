package com.orangegreen.ioc.bean;

/**
 * <p>
 *  bean的引用, 用来记录bean中的属性字段是引用另一个bean
 * </p>
 *
 */

public class BeanReference {

    /**
     * bean名称
     */
    private String name;
    /**
     * 实际的bean 对象
     */
    private Object bean;


    public BeanReference() {
    }

    /**
     * 构造器， 必须包含一个bean名称
     */
    public BeanReference(String name) {
        this.name = name;
    }


    public BeanReference(String name, Object bean) {
        this.name = name;
        this.bean = bean;
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Object getBean() {
        return bean;
    }

    public void setBean(Object bean) {
        this.bean = bean;
    }
}
