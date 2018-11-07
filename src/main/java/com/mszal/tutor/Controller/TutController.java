package com.mszal.tutor.Controller;

import com.mszal.tutor.Entity.Tutorial;
import com.mszal.tutor.Service.TutorialService;
import com.mszal.tutor.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import javax.servlet.http.HttpServletRequest;
import java.security.Principal;
import java.util.ArrayList;

/**
 * Created by Mateusz on 2018-11-04.
 */
@Controller
public class TutController {
    @Autowired
    UserService us;
    @Autowired
    TutorialService tutorialService;
    @GetMapping("/")
    public String tut(Model model,HttpServletRequest request){
      /*  try {
            Principal principal = request.getUserPrincipal();
            System.out.println(principal.getName());


            int id=us.getUserByName(principal.getName());
            System.out.println(id);
        }catch(Exception ex){
            System.out.println("anonymous");
        }*/
      int size=this.tutorialService.getAllTutorials().size();
      if(size>0){
          model.addAttribute("tutorials",this.tutorialService.getAllTutorials());
      }else{
          ArrayList<Tutorial> tut=new ArrayList<>();
          Tutorial tutNotFound=new Tutorial(0,"","Brak dostępnych kursów","","notFoundTut.jpg",0,0,0,0);
          tut.add(tutNotFound);
          model.addAttribute("tutorials",tut);
      }
        return "tut";
    }
    @GetMapping("/addtutorial")
    public String addTutorial(Model model){
        return "addtutorial";
    }
}
