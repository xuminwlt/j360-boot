package me.j360.boot.production.web;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Created with j360-boot -> me.j360.boot.simple.web.
 * User: min_xu
 * Date: 2015/9/23
 * Time: 21:20
 * 说明：
 */

@Controller
public class Index {

    @RequestMapping("/hello")
    @ResponseBody
    String hello(Model model) {
        return "hello";
    }

    @RequestMapping("/index")
    String index(Model model) {
        return "index";
    }
}
