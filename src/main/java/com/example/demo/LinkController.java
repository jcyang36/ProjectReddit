package com.example.demo;

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

    @RequestMapping("/")
    public String home( Model model) {
        return "index";
    }

    @RequestMapping("/add")
    public String goAdd( Model model) {
        model.addAttribute(new Link());
        return "Add";
    }

    @PostMapping("/addsubmit")
    public @ResponseBody
    String addSubmit(@ModelAttribute Link link) {

        return link.toString();
    }

    public static String getDate(){
        SimpleDateFormat dateFormatter = new SimpleDateFormat("MM-dd-yy 'at' hh:mm ");
        Calendar cal = Calendar.getInstance();
        Date now = cal.getTime();

        return dateFormatter.format(now);
    }
}
