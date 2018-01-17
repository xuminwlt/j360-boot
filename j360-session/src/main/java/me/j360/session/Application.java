package me.j360.session;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.session.data.redis.config.annotation.web.http.EnableRedisHttpSession;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;

/**
 * @author: min_xu
 * @date: 2018/1/16 下午8:01
 * 说明：
 */

@Slf4j
@Controller
@EnableRedisHttpSession(maxInactiveIntervalInSeconds=60)
@SpringBootApplication
public class Application {

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }

    @Autowired
    private RedisTemplate redisTemplate;

    @RequestMapping(value = {"/hello"},method = RequestMethod.GET)
    @ResponseBody
    public Object index(HttpServletRequest request){

        String key = "spring:session:sessions:" + request.getSession().getId();
        log.info("{}, {}", key, redisTemplate.hasKey(key));

        log.info("test:{}", redisTemplate.keys("spring"));

        return "端口=" + request.getLocalPort() +  " sessionId=" + request.getSession().getId() +"<br/>";
    }


}
