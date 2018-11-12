package com.mszal.tutor.Controller;

import com.mszal.tutor.Entity.Tutorial;
import com.mszal.tutor.Service.CommentService;
import com.mszal.tutor.Service.TutorialService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.util.ArrayList;

/**
 * Created by Mateusz on 2018-11-11.
 */
@Controller
public class AdminController {
    @Autowired
    private TutorialService tutorialService;
    @Autowired
    private CommentService commentService;

    @GetMapping("/block")
    public String blockTutorial(@RequestParam(value = "idTutToBlock", defaultValue = "0") String idTutBlock, Model model) {
        int idTutInt = Integer.parseInt(idTutBlock);
        if (idTutInt != 0) {
            this.tutorialService.blockTutorial(idTutInt);
        }
        int size = this.tutorialService.getAllTutorials().size();
        if (size > 0) {
            model.addAttribute("tutorials", this.tutorialService.getAllBlockedTut());
        } else {
            ArrayList<Tutorial> tut = new ArrayList<>();
            Tutorial tutNotFound = new Tutorial(0, "", "Brak zablokowanych tutoriali", "", "notFoundTut.jpg", 0, 0, 0, 0, "unlock");
            tut.add(tutNotFound);
            model.addAttribute("tutorials", tut);
        }
        return "block";
    }

    @GetMapping("/unlock")
    public String unlockTut(@RequestParam(value = "idTutUnl", defaultValue = "0") String idTutUnl) {
        int idUnlockInt = Integer.parseInt(idTutUnl);
        this.tutorialService.unlockTutorial(idUnlockInt);
        return "redirect:/block";
    }

    @GetMapping("/deletecomment")
    public ModelAndView deleteComment(@RequestParam(value = "commIdDel", defaultValue = "0") String commIdDel,
                                      @RequestParam(value = "idTutDel", defaultValue = "0") String idTutDel,
                                      @RequestParam(value = "lessNumbDel", defaultValue = "0") String lessNumbDel) {
        int commIdInt=Integer.parseInt(commIdDel);
        this.commentService.deleteComment(commIdInt);
        ModelAndView m = new ModelAndView("redirect:/viewtut");
        m.addObject("idTut", idTutDel);
        m.addObject("lesson", lessNumbDel);
        return m;

    }
}
