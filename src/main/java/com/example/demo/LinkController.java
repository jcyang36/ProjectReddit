package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Calendar;

/**
 * Created by student on 6/22/17.
 */
@Controller
public class LinkController {
    @Autowired
    private LinkRepository linkRepository;

    @RequestMapping("/")
    public String home( Model model) {
        Iterable<Link> linkList = linkRepository.findAllOrderedByTime();
        model.addAttribute("linkList", linkList);

        return "index";
    }

    @RequestMapping("/add")
    public String goAdd( Model model) {
        model.addAttribute(new Link());
        return "Add";
    }

    @RequestMapping("/usersubmissions")
    public String goUserSubmission( Model model) {
        Iterable<Link> linkListUser = linkRepository.findAllByUser("Zack");
        model.addAttribute("linkListUser", linkListUser);
        return "Usersubmissions";
    }

    @PostMapping("/addsubmit")
    public String addSubmit(@ModelAttribute Link link, Model model) {
        link.setTime(new Date());
        model.addAttribute(new Link());
        linkRepository.save(link);
        Iterable<Link> linkList = linkRepository.findAllOrderedByTime();
        model.addAttribute("linkList", linkList);

        return "index";
    }

    @RequestMapping("/login")
    public String login() {
        return "login";
    }
}
