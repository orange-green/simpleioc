package com.orangegreen.ioc.bean;

import java.util.ArrayList;
import java.util.List;

/**
 * <p>
 *  属性类
 * </p>
 *
 * @author wuxj
 * @since 2023/4/14 15:36:41
 */

public class PropertyValues {

    /**
     * 属性list
     */
    private final List<PropertyValue> propertyValueList = new ArrayList<PropertyValue>();

    /**
     * 默认构造器
     */

    public PropertyValues() {
    }


    /**
     * 添加进属性集合
     */
    public void addPropertyValue(PropertyValue pv) {
        propertyValueList.add(pv);
    }

    /**
     * 获取属性集合
     */
    public List<PropertyValue> getPropertyValues() {
        return propertyValueList;
    }
}
