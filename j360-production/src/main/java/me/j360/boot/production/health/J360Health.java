package me.j360.boot.production.health;

import org.springframework.boot.actuate.health.Health;
import org.springframework.boot.actuate.health.HealthIndicator;
import org.springframework.stereotype.Component;

/**
 * Created with j360-boot -> me.j360.boot.production.health.
 * User: min_xu
 * Date: 2015/9/25
 * Time: 11:07
 * 说明：
 */

@Component
public class J360Health implements HealthIndicator {
    @Override
    public Health health() {
        int errorCode = check(); // perform some specific health check
        if (errorCode != 0) {
            return Health.down().withDetail("Error Code", errorCode).build();
        }
        return Health.up().build();
    }

    private int check(){
        return 1;
    }
}