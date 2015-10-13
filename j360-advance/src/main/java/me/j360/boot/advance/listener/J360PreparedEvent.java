package me.j360.boot.advance.listener;

import org.springframework.boot.context.event.ApplicationPreparedEvent;
import org.springframework.context.ApplicationListener;

/**
 * Created with springbootweb -> me.j360.springboot.simple.listener.
 * User: min_xu
 * Date: 2015/7/29
 * Time: 11:29
 * 说明：
 */
public class J360PreparedEvent implements ApplicationListener<ApplicationPreparedEvent> {
    @Override
    public void onApplicationEvent(ApplicationPreparedEvent applicationPreparedEvent) {
        System.out.println(this.getClass().getCanonicalName());
    }
}
