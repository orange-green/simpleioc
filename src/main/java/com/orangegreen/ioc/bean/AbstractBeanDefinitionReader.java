package com.orangegreen.ioc.bean;

import com.orangegreen.ioc.io.ResourceLoader;

import java.util.HashMap;
import java.util.Map;

/**
 * <p>
 *  抽象的bean定义读取类, 将资源解析成BeanDefinition对象
 * </p>
 *
 * @author wuxj
 * @since 2023/4/14 16:51:44
 */

public abstract class AbstractBeanDefinitionReader implements BeanDefinitionReader {
    /**
     * 注册bean容器
     */
    private Map<String, BeanDefinition> beanDefinitionMap;

    /**
     * 资源加载器
     */
    private ResourceLoader resourceLoader;


    /**
     * 构造器器必须有一个资源加载器， 默认插件创建一个map容器
     *
     * @param resourceLoader 资源加载器
     */
    protected AbstractBeanDefinitionReader(ResourceLoader resourceLoader) {
        this.beanDefinitionMap = new HashMap<String, BeanDefinition>();
        this.resourceLoader = resourceLoader;
    }


    /**
     * 获取容器
     */
    public Map<String, BeanDefinition> getBeanDefinitionMap() {
        return beanDefinitionMap;
    }

    /**
     * 获取资源加载器
     */
    public ResourceLoader getResourceLoader() {
        return resourceLoader;
    }


}
