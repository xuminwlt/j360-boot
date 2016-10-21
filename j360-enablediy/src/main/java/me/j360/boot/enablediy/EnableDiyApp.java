package me.j360.boot.enablediy;

import org.springframework.context.annotation.Import;

import java.lang.annotation.*;

/**
 * Package: me.j360.boot.enablediy
 * User: min_xu
 * Date: 2016/10/21 下午4:13
 * 说明：
 */

@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
@Documented
@Import({DiyAppConfiguration.class, DiyController.class})
public @interface EnableDiyApp {


}
