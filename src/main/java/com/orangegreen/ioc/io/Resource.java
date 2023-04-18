package com.orangegreen.ioc.io;

import java.io.InputStream;

/***
 * 资源定义

 */
public interface Resource {
    /**
     * 获取输入流
     */
    InputStream getInputStream() throws Exception;


}
