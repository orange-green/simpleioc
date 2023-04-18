package com.orangegreen.ioc.io;

import java.io.InputStream;
import java.net.URL;
import java.net.URLConnection;

/**
 * 资源URL

 */

public class ResourceURL implements Resource{
    /**
        URL对象用于接收网址或文件路径
     */
    private final URL url;

    public ResourceURL(URL url) {
        this.url = url;
    }

    /**
     *  获取URL对象的输入流
     */
    @Override
    public InputStream getInputStream() throws Exception {
        URLConnection urlConnection = url.openConnection();
        urlConnection.connect();

        return urlConnection.getInputStream();
    }
}
