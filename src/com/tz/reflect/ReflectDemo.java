package com.tz.reflect;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * 反射
 *
 * 学习反射 和 设计模式，为什么要学习它，学了它能干、如下：
 *      1、反射就是创建对象的另一种方式而已
 *          一、创建对象的方法有：
 *              1、new  申请内在空间。
 *              2、反射。
 *              3、clone(克隆)
 *              4、字节流(objectIo)、就是流，用在 webservice,webscoket ,对象传递、必须要实现 序列化
 *
 */
public class ReflectDemo {
    public static void main(String[] args) {
        //User user = new User("keke",24);
        //user.say();
        // 私有的你就不能直接 点 出来了，可以使用 setXxx() 反射 构造 ，这三种方式来 给私有的赋值。
        //user.age


        // 用反射来创建对象。
        try {
            // 去加载它的 class 。class 对象。
            // 好像这种不能给有参数的构造赋值。
            //Class clz = Class.forName("com.tz.reflect.User");
            // 赋值之前必须先要有对象才行。

            // 类加载器。 这个和上面哪个 class 对象一样，先上面哪个。Thread.currentThread()当前线程。
            ClassLoader loader = Thread.currentThread().getContextClassLoader();
            Class clz = loader.loadClass("com.tz.reflect.User");
            // 开始用反射创建对象。
            //User user = (User) clz.newInstance();



            // 解析构造函数
            // class 文件里面 注要就是 属性、方法、构造函数、代码块 这些东东。就开始解析这些东东。
            // 解析构造函数，它返回的是一个构造函数类
            // 解析构造函数的目的，1、创建对象。2、赋值。这也是构造函数作用。
            Constructor[] constructor = clz.getDeclaredConstructors();
            // 给第一个构造函数赋值。因为你可能有多个构造函数了, 它是根据 user 类里面的 构造顺序来的
            // 报这个错，java.lang.IllegalArgumentException: wrong number of arguments 你就把哪个参数 改下来了。
            // 构造函数的顺序是从0 开始
            User user = (User) constructor[1].newInstance("刘德华",99);
            System.out.println(user.username);



            // 反射解析方法，IOC 就是解析 构造函数 和 解析 方法的。
            // getDeclaredMethod() 这个方法是：你哪个 User 类里面你要执行哪个方法就把方法传入，第二个参数是：这个方法的参数。
            Method method = clz.getDeclaredMethod("say");
            // 方法解析成功就调用方法
            // 参数是：1、是哪个类里面的方法。2、第二参数是这个方法的参数
            method.invoke(user);


            // 以上做了这么多的事情，其实就是下面这两句代码的功能。
            //User user = new User("keke",24);
            //user.say();



        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        }

    }
}
