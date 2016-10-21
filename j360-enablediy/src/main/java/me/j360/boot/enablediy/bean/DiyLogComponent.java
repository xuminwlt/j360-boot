package me.j360.boot.enablediy.bean;

/**
 * Package: me.j360.boot.enablediy.bean
 * User: min_xu
 * Date: 2016/10/21 下午4:16
 * 说明：
 */
public class DiyLogComponent {

    private String author;

    public DiyLogComponent(String author){
        this.author = author;
    }


    public String log(String logText){
        System.out.println(logText);
        return author + ":" + logText;
    }
}
