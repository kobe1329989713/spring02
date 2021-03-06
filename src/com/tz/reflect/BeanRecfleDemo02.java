package com.tz.reflect;

import com.tz.ioc.core.GeLi;
import com.tz.ioc.core.KeKe;
import com.tz.ioc.core.LiuDeHua;
import com.tz.ioc.core.MoGongMovie;

import java.lang.reflect.Constructor;
import java.lang.reflect.Method;

/**
 * Spring IOC 完成的执行过程、如下：
 */
public class BeanRecfleDemo02 {

    public static void main(String[] args) {
        try {

            //创建刘德华对象
            // 获取 Class 对象。
            //ClassLoader liudehuaClassLoader = Thread.currentThread().getContextClassLoader();
            //Class clz = liudehuaClassLoader.loadClass("com.tz.ioc.core.LiuDeHua");


            //解析构造函数
            //Constructor[] constructors = clz.getDeclaredConstructors();
            //com.tz.ioc.core.LiuDeHua liudehua = (com.tz.ioc.core.LiuDeHua) constructors[1].newInstance("刘德华");


            // 用封装的方法 来做
            LiuDeHua liuDeHua = createObject("com.tz.ioc.core.LiuDeHua", 1, "刘德华");


            //创建keke对象
            //ClassLoader kekeClassLoader = Thread.currentThread().getContextClassLoader();
            //Class kclz = liudehuaClassLoader.loadClass("com.tz.ioc.core.KeKe");
            ////解析构造函数，这也是构造注入。
            //Constructor[] kconstructors = kclz.getDeclaredConstructors();
            //com.tz.ioc.core.KeKe keke = (com.tz.ioc.core.KeKe) kconstructors[1].newInstance("keke");


            // 用封装的方法 来做
            KeKe keke = createObject("com.tz.ioc.core.KeKe", 1, "keke");


            //剧本
            //ClassLoader jubenClassLoader = Thread.currentThread().getContextClassLoader();
            //Class jclz = jubenClassLoader.loadClass("com.tz.ioc.core.MoGongMovie");
            //MoGongMovie moGongMovie = (MoGongMovie) jclz.newInstance();


            // 这个就是 setXxx() 注入原理。
            //Method method = jclz.getDeclaredMethod("setGeLi", GeLi.class);
            //method.invoke(moGongMovie, keke);


            //moGongMovie.startMovie();


            // 用封装的方法 来做，set注入来做。
            MoGongMovie gongMovie = objectNewInstance("com.tz.ioc.core.MoGongMovie");
            gongMovie.setGeLi(keke);
            gongMovie.startMovie();



            //LiuDeHua liuDeHua2 = new LiuDeHua();
            //KeKe ke = new KeKe();
            //MoGongMovie gongMovie2 = new MoGongMovie();
            //gongMovie2.setGeLi(ke);
            //gongMovie2.startMovie();


            // 以上这些 Spring 把上面这些 解析出来后，是放在 一个 map 里面的。

        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    /**
     * 上面的封装
     *      之 解析构造
     *
     * @param packageName 包名
     * @param index       解析第几个构造函数
     * @param args        构造的参数，是动态参数
     * @param <T>         返回的具体类型
     * @return
     */
    public static <T> T createObject(String packageName, int index, Object... args) {
        try {
            ClassLoader liudehuaClassLoader = Thread.currentThread().getContextClassLoader();
            Class clz = liudehuaClassLoader.loadClass(packageName);
            //解析构造函数
            Constructor[] constructors = clz.getDeclaredConstructors();
            T liudehua = (T) constructors[index].newInstance(args);
            return liudehua;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }


    /**
     * 上面的封装
     *      之 set 注入封装。
     *
     * @param packageName 包名
     * @param <T> 返回的具体类型
     * @return
     */
    public static <T> T objectNewInstance(String packageName){
        try {
            ClassLoader liudehuaClassLoader = Thread.currentThread().getContextClassLoader();
            Class clz = liudehuaClassLoader.loadClass(packageName);
            T liudehua = (T) clz.newInstance();
            return liudehua;
        } catch(Exception e) {
            e.printStackTrace();
            return null;
        }
    }

}
