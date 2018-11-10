package com.mszal.tutor.Controller;

import com.mszal.tutor.Entity.SubTutorial;
import com.mszal.tutor.Entity.Tutorial;
import com.mszal.tutor.Service.CategoryService;
import com.mszal.tutor.Service.SubTutService;
import com.mszal.tutor.Service.TutorialService;
import com.mszal.tutor.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;
import java.security.Principal;
import java.util.ArrayList;

/**
 * Created by Mateusz on 2018-11-04.
 */
@Controller
public class TutController {
    @Autowired
    SubTutService subTutService;
    @Autowired
    UserService us;
    @Autowired
    TutorialService tutorialService;
    @Autowired
    CategoryService categoryService;

    @GetMapping("/")
    public String tut(Model model, HttpServletRequest request) {

        int size = this.tutorialService.getAllTutorials().size();
        if (size > 0) {
            model.addAttribute("tutorials", this.tutorialService.getAllTutorials());
        } else {
            ArrayList<Tutorial> tut = new ArrayList<>();
            Tutorial tutNotFound = new Tutorial(0, "", "Brak dostępnych kursów", "", "notFoundTut.jpg", 0, 0, 0, 0);
            tut.add(tutNotFound);
            model.addAttribute("tutorials", tut);
        }
        return "tut";
    }

    @GetMapping("/addtutorial")
    public String addTutorial(Model model) {
        model.addAttribute("categories", this.categoryService.getAllCategories());
        return "addtutorial";
    }

    @PostMapping("/addtutorial")
    public String addTutorial(@RequestParam(value = "sendImg", defaultValue = " ") String sendImg,
                              @RequestParam(value = "nazPor", defaultValue = " ") String tutName,
                              @RequestParam(value = "opisPor", defaultValue = " ") String tutDesc,
                              @RequestParam(value = "kat", defaultValue = " ") String cat,
                              @RequestParam(value = "userName", defaultValue = " ") String uName) {
        System.out.println(sendImg);
        int userId = this.us.getUserByName(uName);
        int catId = this.categoryService.getCategoryId(cat);
        this.tutorialService.addTutorial(tutName, tutDesc, sendImg, userId, catId);

        return "redirect:/mytutorials";
    }

    @GetMapping("/viewtut")
    public String viewTutorial(@RequestParam(value = "idTut", defaultValue = "1") String tutId,
                               @RequestParam(value = "lesson", defaultValue = "1") String lesson, Model model) {
        SubTutorial s=new SubTutorial();

        System.out.print(lesson);
        int tutorialId=Integer.parseInt(tutId);
        int lessonInt=Integer.parseInt(lesson);
        s=this.subTutService.getEntireLesson(tutorialId,lessonInt);
        System.out.println(s.getSubject());
        model.addAttribute("tutId",tutId);
        model.addAttribute("subtutorials",this.subTutService.getAllLessons(tutorialId));
        model.addAttribute("lesson",this.subTutService.getEntireLesson(tutorialId,lessonInt));
        return "viewTut";
    }
}
