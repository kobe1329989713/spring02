package com.tz.reflect;

/**
 * 反射讲解。
 */
public class User {
    public String username;
    private int age;

    public User() {
    }

    public User(String username, int age) {
        this.username = username;
        this.age = age;
    }



    public void say(){
        System.out.println(this.username + "今年" + this.age + "岁。");
    }

    // this 可以用于 static 中吗？ 答：不行，就是 static 不能和 this 同时使用的
    // this 是属于当前 对象的。它是每个对象都有独立的内在空间的。
    // static 是属于 类的，你改了 static 的什么东东，也会把它的改了，就像游戏当中的帮会组织样。
}
