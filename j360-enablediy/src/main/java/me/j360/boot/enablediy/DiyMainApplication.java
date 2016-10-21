package me.j360.boot.enablediy;

import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.builder.SpringApplicationBuilder;

/**
 * Package: me.j360.boot.enablediy
 * User: min_xu
 * Date: 2016/10/21 下午4:00
 * 说明：
 */
@EnableAutoConfiguration
@EnableDiyApp
public class DiyMainApplication {

    public static void main(String[] args) {
        new SpringApplicationBuilder(DiyMainApplication.class)
                .properties("spring.config.name=diy").run(args);
    }

}
