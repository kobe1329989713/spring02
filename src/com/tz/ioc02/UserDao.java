package com.tz.ioc02;

import org.springframework.stereotype.Component;

/**
 *  自动 注入 @AutoWrite
 *
 *   Spring中 加入Spring任意注解 ，就代表了，它就Spring容器所管理起来了。就必须在找到你，
 *   而要找到你，就必须要 扫包了？？？
 *
 *   如果没有加Spring注解的，就是 你是你，我是我
 *   被 Spring管理的东东，放在一起，没有被管理放在一直。
 */
@Component
public class UserDao {

    public void save(){
        System.out.println("找到你了吗？我要保存了？");
    }
}
