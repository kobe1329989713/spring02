package com.tz.ioc;

/**
 * 导演类，IOC 来，调配，各种资源。
 */
public class Director {

    /**
     * 导演一部戏
     */
    public void deirectorMove() {

        // 导演先选择一个演员
        GeLi geLi = new LiuDeHua("mar");
        // 在选择一个剧本。剧本还可以在抽象出一个父类出来。
        MoGongMovie moGongMovie = new MoGongMovie();
        moGongMovie.cityGateAsk(geLi);
    }


    public static void main(String[] args) {
        new Director().deirectorMove();
    }
}
