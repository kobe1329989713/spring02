
package com.tz.pattern;

/**
 *   把这个类 搞成 单例的。
 *
 *   一个简单的单例类。
 *
 */
public class Singleton {

	// 1、构造私有化
	private Singleton(){

	}

	public int num;
	static Singleton singleton = null;

	// 提供一个公开的 获取这个 对象的方法。
	public static Singleton getInstance(){
		if(singleton==null){
			singleton = new Singleton();
		}
		return singleton;
	}


}
