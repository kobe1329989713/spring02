package com.tz.reflect;

import com.tz.ioc.core.GeLi;
import com.tz.ioc.core.MoGongMovie;

import java.lang.reflect.Constructor;
import java.lang.reflect.Method;

/**
 * Spring IOC 完成的执行过程、如下：
 */
public class BeanRecfleDemo {

    public static void main(String[] args) {
        try {

            //创建刘德华对象
            // 获取 Class 对象。
            ClassLoader liudehuaClassLoader = Thread.currentThread().getContextClassLoader();
            Class clz = liudehuaClassLoader.loadClass("com.tz.ioc.core.LiuDeHua");

            //解析构造函数
            Constructor[] constructors = clz.getDeclaredConstructors();
            com.tz.ioc.core.LiuDeHua liudehua = (com.tz.ioc.core.LiuDeHua) constructors[1].newInstance("刘德华");

            //创建keke对象
            ClassLoader kekeClassLoader = Thread.currentThread().getContextClassLoader();
            Class kclz = liudehuaClassLoader.loadClass("com.tz.ioc.core.KeKe");
            //解析构造函数，这也是构造注入。
            Constructor[] kconstructors = kclz.getDeclaredConstructors();
            com.tz.ioc.core.KeKe keke = (com.tz.ioc.core.KeKe) kconstructors[1].newInstance("keke");


            //剧本
            ClassLoader jubenClassLoader = Thread.currentThread().getContextClassLoader();
            Class jclz = jubenClassLoader.loadClass("com.tz.ioc.core.MoGongMovie");
            MoGongMovie moGongMovie = (MoGongMovie) jclz.newInstance();

            // 这个就是 setXxx() 注入原理。
            Method method = jclz.getDeclaredMethod("setGeLi", GeLi.class);
            method.invoke(moGongMovie, keke);


            moGongMovie.startMovie();

            // 以上这些 Spring 把上面这些 解析出来后，是放在 一个 map 里面的。

        } catch (Exception e) {
            e.printStackTrace();
        }
    }




}
