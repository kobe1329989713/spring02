package com.tz.ioc02;

/**
 *  动态参数，讲解。
 *
 *  计到容器 马上想到 servlet jsp tomcat
 */
public class DParams {

    // 动态参数，必须是放在最后，也不能有多个动态 参数。
    public static void sum(int ...params){
        int sum = 0;
        for (int i : params){
            sum += i;
        }
        System.out.println(sum);
    }

    public static void main(String[] args) {
        sum();
        sum(1,1,2,2,2,2,2,2,10);
    }
}
