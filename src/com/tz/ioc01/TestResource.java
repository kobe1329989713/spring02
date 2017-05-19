package com.tz.ioc01;

import com.tz.ioc.core.MoGongMovie;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.FileSystemResource;
import org.springframework.core.io.Resource;

/**
 *  解析 bean.xml 文件
 *
 *  加载资源文件有：
 1、ClassPathReSource 针对于当前项目的源文件夹的
 2、FileSystemResource 针对于 系统磁盘的。
 3、ServletContextResource 针对于容器、web.xml 这个不用你管的。
 *
 */
public class TestResource {

    public static void main(String[] args) {
        // 加载配置文件。
        Resource resource = new ClassPathResource("bean.xml");
        //2、FileSystemResource 针对于 系统磁盘的。
        //Resource resource = new FileSystemResource("D:/tzprojects/tzspring02/src/bean.xml");
        BeanFactory beanFactory = new XmlBeanFactory(resource);

        // 获取
        MoGongMovie moGongMovie = (MoGongMovie) beanFactory.getBean("movie");
        MoGongMovie moGongMovie2 = (MoGongMovie) beanFactory.getBean("movie");
        // 开始导戏。
        moGongMovie.startMovie();
        // 它直接在 配置文件里面就可以换演员了。


        // 默认就是单例的。在 web 端 必须要做多例的才行。所以 web 端 的 @Controller 注解 代表的就是多例的。
        // @Service @Repository 都是单例的。所以这就是 注解 比 xml 配置要好的多。
        System.out.println(moGongMovie == moGongMovie2);
    }
}
