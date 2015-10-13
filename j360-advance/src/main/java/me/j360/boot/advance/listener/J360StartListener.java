package me.j360.boot.advance.listener;

import org.springframework.boot.context.event.ApplicationStartedEvent;
import org.springframework.context.ApplicationListener;

/**
 * Created with springbootweb -> me.j360.springboot.simple.listener.
 * User: min_xu
 * Date: 2015/7/29
 * Time: 10:35
 * 说明：
 */

public class J360StartListener implements ApplicationListener<ApplicationStartedEvent> {

    @Override
    public void onApplicationEvent(ApplicationStartedEvent applicationStartedEvent) {
        System.out.println("applicationStartedEvent");
    }
}
