
package com.tz.pattern;

import java.lang.reflect.Constructor;
import java.lang.reflect.Method;
import java.util.Map;

import com.tz.ioc.core.GeLi;
import com.tz.ioc.core.LiuDeHua;
import com.tz.ioc.core.MoGongMovie;
import com.tz.pattern.Singleton;


/**
 *
 * 单例模式。
 * 		23模式  都是讲如何创建对象 ，
 * 	    	1、高效的创建对象。
 * 	    	2、封装 继承 多态 发挥最大化。
 * 	    	3.模式应用的场景
 *	 工厂，抽象工厂，单例，装修，观察模式。先学。
 *
 */
public class SingletonDemo {

	public static void main(String[] args) {
		//设计解决什么样子的问题：---对象，
		//应用的场景--单列模式

        // 单例
		Singleton singleton = Singleton.getInstance();
		singleton.num++;
		System.out.println(singleton.num);
		Singleton singleton2 = Singleton.getInstance();
		singleton2.num++;
		System.out.println(singleton2.num);
		Singleton singleton3 = Singleton.getInstance();
		singleton3.num++;
		System.out.println(singleton3.num);

		System.out.println("===================================");


        // 非 单例
		NoSingleton noSingleton = new NoSingleton();
		noSingleton.num ++;
		System.out.println(noSingleton.num);

		NoSingleton noSingleton2 = new NoSingleton();
		noSingleton2.num ++;
		System.out.println(noSingleton2.num);


		NoSingleton noSingleton3 = new NoSingleton();
		noSingleton3.num ++;
		System.out.println(noSingleton3.num);

	}
}
