package com.orangegreen.ioc.bean;

/**
 * <p>
 *
 * </p>
 *
 * @author wuxj
 * @since 2023/4/14 16:25:35
 */

public class PropertyValue {
    /**
     * 属性名称
     */
    private final String name;

    /**
     * 属性对象
     */
    private final Object value;


    public PropertyValue(String name, Object value) {
        this.name = name;
        this.value = value;
    }

    public String getName() {
        return name;
    }

    public Object getValue() {
        return value;
    }
}
