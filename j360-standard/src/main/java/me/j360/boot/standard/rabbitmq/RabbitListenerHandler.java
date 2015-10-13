package me.j360.boot.standard.rabbitmq;

import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Component;

import java.util.Date;

/**
 * Created with j360-boot -> me.j360.boot.standard.rabbitmq.
 * User: min_xu
 * Date: 2015/10/12
 * Time: 16:34
 * ËµÃ÷£º
 */
@Component
@RabbitListener(queues = "foo")
public class RabbitListenerHandler {


    @RabbitHandler
    public void process(@Payload String foo) {
        System.out.println(new Date() + ": " + foo);
    }
}
