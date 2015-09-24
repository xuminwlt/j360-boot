package me.j360.boot.standard.web;

import me.j360.boot.standard.activemq.Producer;
import me.j360.boot.standard.domain.Note;
import me.j360.boot.standard.repository.NoteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpSession;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.UUID;

/**
 * Created with j360-boot -> me.j360.boot.simple.web.
 * User: min_xu
 * Date: 2015/9/23
 * Time: 21:20
 * 说明：
 */

@Controller
public class IndexController {

    @Autowired
    private Producer producer;
    @Autowired
    private NoteRepository noteRepository;


    @RequestMapping("/hello")
    @ResponseBody
    String hello(Model model) {
        this.producer.send(this.message);
        return this.message;
    }

    @RequestMapping("/index")
    @Transactional(readOnly = true)
    public ModelAndView index() {
        List<Note> notes = this.noteRepository.findAll();
        ModelAndView modelAndView = new ModelAndView("index");
        modelAndView.addObject("notes", notes);
        return modelAndView;
    }

    @RequestMapping("/uid")
    String uid(HttpSession session) {
        UUID uid = (UUID) session.getAttribute("uid");
        if (uid == null) {
            uid = UUID.randomUUID();
        }
        session.setAttribute("uid", uid);
        return uid.toString();
    }


    @Value("${application.message:Hello World}")
    private String message = "Hello World";

    @RequestMapping("/")
    public String welcomej360(Map<String, Object> model) {
        model.put("time", new Date());
        model.put("message", this.message);
        return "welcomej360";
    }
}
