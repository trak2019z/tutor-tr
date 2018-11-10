package com.mszal.tutor.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

/**
 * Created by Mateusz on 2018-11-09.
 */
@Controller
public class SubTutController {
    @GetMapping("/addsubtut")
    public String addSubTut(Model model){
        return "addsubtut";
    }
    @PostMapping("/addsubtut")
    public String addSubTut(){
        return "redirect:/mytutorials";
    }
}
