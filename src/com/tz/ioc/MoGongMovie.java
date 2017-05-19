package com.tz.ioc;

/**

    剧本类。

 * 拍电影。
 * MoGong(电影名称)
 * (角色)，哪个演员饰演什么角色。
 * (剧本)，攻城(是一个动作，就是一个方法。)
 * (导演)，Zhangymou
 *
 *
 * 场景：
 * 刘德华饰演墨子到达梁园城都下，城上将军就问：来者何人，刘德华回答道：墨者隔离
 *
 */
public class MoGongMovie {


    private LiuDeHua geli;

    /**
     * 哪个回答道,（城上将军就问：来者何人）
     */
    public void cityGateAsk(GeLi geLi){
        // 如果，LiuDeHua 这个类出现问题了，下面的方法就调用不了，？？？
        //LiuDeHua liuDeHua = new LiuDeHua();
        //liuDeHua.responseAsk("墨者革隔");

        // 解决如下，把liuDeHua向上抽象出一个父类出来。GeLi
        // 指定某一个做。有重写知识。编译看左边，运行看右边。多态
        //GeLi  liuDeHua = new LiuDeHua("刘德华 ");
        //liuDeHua.responseAsk("墨者革隔");


        // 就可以随意切换其它演员来饰演。
        //GeLi keke = new Keke("keke");
        //keke.responseAsk("keke墨者革隔");


        // 这个剧本 还很依懒于 角色 和 某个具体的角色
        // 要到达这个剧本可以随意切换。IOC 了,就是装配
        geLi.responseAsk("墨者革隔");
    }
    // 理解 优化，程序精华

    public static void main(String[] args) {
        MoGongMovie moGongMovie = new MoGongMovie();
        //moGongMovie.cityGateAsk();
    }

    public void setGeli(LiuDeHua geli) {
        this.geli = geli;
    }

    public LiuDeHua getGeli() {
        return geli;
    }
}
