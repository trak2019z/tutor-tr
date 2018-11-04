package com.mszal.tutor.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
/**
 * Created by Mateusz on 2018-11-04.
 */
@Controller
public class TutController {

    @GetMapping("/")
    public String tut(Model model){
        return "tut";
    }
}
