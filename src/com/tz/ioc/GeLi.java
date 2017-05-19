package com.tz.ioc;

/**
 * 11111
 *
 *
 * 解决如下，把liuDeHua向上抽象出一个父类出来。GeLi
 */
public class GeLi {
    /**
     * 演员名称。
     */
    private String actorName;

    // ==
    public GeLi(String actorName) {
        this.actorName = actorName;
    }

    public GeLi() {}

    /**
     * 回答(父)
     * @param message content
     */
    public void responseAsk(String message){
        // 哪个演员来演，回答的是什么。
        System.out.println(this.actorName + "，===，" +message);
    }
}
