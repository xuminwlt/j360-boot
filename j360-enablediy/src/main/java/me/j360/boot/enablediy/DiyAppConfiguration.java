package me.j360.boot.enablediy;

import me.j360.boot.enablediy.bean.DiyLogComponent;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * Package: me.j360.boot.enablediy
 * User: min_xu
 * Date: 2016/10/21 下午4:14
 * 说明：
 */
@Configuration
public class DiyAppConfiguration {


    @Bean
    public DiyLogComponent diyLogComponent(@Value("${diy.author:j360}") String author){
        return new DiyLogComponent(author);
    }



}
