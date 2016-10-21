package me.j360.boot.enablediy;

import me.j360.boot.enablediy.bean.DiyLogComponent;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import static org.springframework.web.bind.annotation.RequestMethod.GET;

/**
 * Package: me.j360.boot.enablediy
 * User: min_xu
 * Date: 2016/10/21 下午4:22
 * 说明：
 */
@RestController
public class DiyController {

    @Autowired
    private DiyLogComponent diyLogComponent;


    @RequestMapping(value = "/api/v1/diy", method = GET)
    @ResponseStatus(HttpStatus.ACCEPTED)
    public String diy(
            @RequestParam String log
    ) {
        return diyLogComponent.log(log);
    }
}
