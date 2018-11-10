package com.mszal.tutor.Controller;

import com.mszal.tutor.Service.SubTutService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * Created by Mateusz on 2018-11-09.
 */
@Controller
public class SubTutController {
    @Autowired
    private SubTutService subTutService;

    @GetMapping("/addsubtut")
    public String addSubTut(@RequestParam("idTut") String tutId, Model model) {
        //System.out.println(tutId);
        model.addAttribute("tutId", tutId);
        return "addsubtut";
    }

    @PostMapping("/addsubtut")
    public String addSubTut(@RequestParam("sendImg") String sImg,
                            @RequestParam("tutId") String tutId,
                            @RequestParam("lessSubj") String lessSubj,
                            @RequestParam("cont") String cont) {
        // System.out.println(tutId + "  "+lessSubj +"  "+ cont);
        System.out.println(tutId);
        int tutorialId = Integer.parseInt(tutId);
        int lessNumber = this.subTutService.checkLessonCount(tutorialId);
        lessNumber++;
        this.subTutService.addsubTut(lessSubj, cont, lessNumber, tutorialId);
        return "redirect:/mytutorials";
    }
}
