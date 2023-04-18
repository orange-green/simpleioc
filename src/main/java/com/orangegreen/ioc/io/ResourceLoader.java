package com.orangegreen.ioc.io;

import java.net.URL;

/**
 * <p>
 *  资源加载器
 * </p>
 *
 * @author wuxj
 * @since 2023/4/14 16:47:23
 */

public class ResourceLoader {

    /**
     * 给定一个位置， 使用类加器的资源加载URL，并创建一个“资源URL”对象，便于获取输入流
     */

    public ResourceURL getResourceURL(String location) {
        URL url = this.getClass().getClassLoader().getResource(location);
        return new ResourceURL(url);
    }
}
