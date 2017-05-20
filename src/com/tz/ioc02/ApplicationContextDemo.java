package com.tz.ioc02;

import com.tz.ioc.core.KeKe;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;

/**
 *  在开发中，一般用它。找 配置文件
 */
public class ApplicationContextDemo {
    public static void main(String[] args) {
        // 通过 类路径 来找配置文件。这种启动会很慢(因为它要加载很多类进去)，它的运行时速度会很快
        // 你加一个懒加载，它就会，只在要用到它时，在去加载了。
        //ApplicationContext context = new ClassPathXmlApplicationContext("classpath:bean.xml");

        // 通过 磁盘 来找。
        //ApplicationContext context = new FileSystemXmlApplicationContext("F:/idea/ideaSpace/space02/tzspring01/spring02/config/bean.xml");

        // 通过 容器 来加载。
        //new ClassPathXmlApplicationContext(new String[]{"classpath:bean01.xml","classpath:bean02.xml","classpath:bean02.xml"});
        // 也可以写成 下面这种。
        ApplicationContext context = new ClassPathXmlApplicationContext("classpath:bean.xml","classpath:bean01.xml","classpath:bean02.xml","classpath:bean03.xml");

        KeKe ke = (KeKe) context.getBean("keke");
        ke.responseAsk("打游戏");
    }
}
