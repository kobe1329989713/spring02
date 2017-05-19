package com.tz.ioc02;

import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.FileSystemResource;
import org.springframework.core.io.Resource;
import org.springframework.core.io.ResourceLoader;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.core.io.support.ResourcePatternResolver;

import java.io.IOException;

/**
 * 加载 xxx.xml 注：不包括 web.xml 里面的哪个。
 */
public class ResourceDemo {
    public static void main(String[] args) throws IOException {
                                            // 这里不要加 classpath:
        //Resource resource = new ClassPathResource("bean.xml");
        ////resource = new FileSystemResource(file)
        //XmlBeanFactory xmlBeanFactory = new XmlBeanFactory(resource);


        // Spring 容器加载资源文件的核心类。配置文件不能重名。不然可能会被覆盖掉。
        ResourceLoader resourceLoader = new PathMatchingResourcePatternResolver();
        Resource resource = resourceLoader.getResource("classpath:bean.xml");
        // classpath:/ 和 classpath:  是一样的
        // classpath*:bean.xml








        // 加载磁盘里面的，这就是为什么 前面需要加 前缀了，跟据前缀 来选择进入到哪个里面去。
        //Resource resource = resourceLoader.getResource("file:bean.xml");

        // 打印 配置文件相关信息。
        // 获取配置文件的名称。
        System.out.println(resource.getDescription());
        // 获取配置文件的路径。注：是找到的 class 路径 ，不是磁盘路径，因为它的前缀 是 classpath
        System.out.println(resource.getFile().getAbsolutePath());

    }
}
