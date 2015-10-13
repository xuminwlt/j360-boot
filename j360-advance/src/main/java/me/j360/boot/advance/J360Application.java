package me.j360.boot.advance;

import org.springframework.boot.SpringApplication;

/**
 * Created with j360-boot -> me.j360.springboot.simple.
 * User: min_xu
 * Date: 2015/7/29
 * Time: 10:17
 * 说明：Springboot入口
 */
public class J360Application {

    /**
     * 默认情况下使用该方法执行
     * */
    public static void main(String[] args) {
        SpringApplication.run(J360MainConfiguration.class, args);
    }


    /**
     * 如果默认的SpringApplication不符合你的口味，你可以创建一个本地的实例并自定义它。例如，关闭banner你可以这样写
     * */
    public static void defindMain(String[] args){
        SpringApplication app = new SpringApplication(J360MainConfiguration.class);
        app.setShowBanner(false);
        //app.addListeners(new J360StartListener());
        app.run(args);
    }


}
