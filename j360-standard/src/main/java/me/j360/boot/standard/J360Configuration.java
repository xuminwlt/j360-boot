package me.j360.boot.standard;

import me.j360.boot.standard.rabbitmq.Sender;
import org.apache.activemq.command.ActiveMQQueue;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.context.web.SpringBootServletInitializer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.scheduling.annotation.EnableScheduling;

import javax.annotation.PostConstruct;
import javax.jms.Queue;
import java.util.Date;

/**
 * Created with springbootweb -> me.j360.springboot.jar.
 * User: min_xu
 * Date: 2015/7/28
 * Time: 15:28
 * 说明：
 */

@SpringBootApplication
@EnableScheduling
public class J360Configuration extends SpringBootServletInitializer {

    private static final Logger logger = LoggerFactory
            .getLogger(J360Configuration.class);

    @PostConstruct
    public void logSomething() {
        logger.debug("j360 Debug Message");
        logger.trace("j360 Trace Message");
    }

    @Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
        return application.sources(J360Configuration.class);
    }

    @Bean
    public Queue queue() {
        return new ActiveMQQueue("sample.queue");
    }

    @Bean
    public Sender mySender() {
        return new Sender();
    }

    @Bean
    public org.springframework.amqp.core.Queue fooQueue() {
        return new org.springframework.amqp.core.Queue("foo");
    }


}
