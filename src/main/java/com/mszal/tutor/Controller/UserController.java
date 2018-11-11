package com.mszal.tutor.Controller;
import com.mszal.tutor.Entity.Tutorial;
import com.mszal.tutor.Service.PasswordEncoderGenerator;
import com.mszal.tutor.Service.TutorialService;
import com.mszal.tutor.Service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;
import java.security.Principal;
import java.util.ArrayList;

/**
 * Created by Mateusz on 2018-11-04.
 */
@Controller
public class UserController {
    @Autowired
    private UserService userService;
    @Autowired
    private TutorialService tutorialService;

    /**
     * Metoda ta zwraca formularz rejestracyjny
     * @return Formularz rejestracyjny
     */
    @RequestMapping(value = "/register", method = RequestMethod.GET)
    public String addUserPanel() {
        return "register";
    }

    /**
     * Metoda ta dodaje nowego użytkownika na podstawie danych pobranych z formularza
     * @param username Nazwa użytkownika (login)
     * @param password Hasło użytkownika
     * @param email Email użytkownika
     * @return Jeżeli wprowadzone w formularzu dane są niepoprawne zwracany jest widok formularza rejestracyjnego, w przeciwnym wypadku użykownik jest przenoszony do strony głównej
     */
    @RequestMapping(value = "/register", method = RequestMethod.POST)
    public String addUser(@RequestParam(value = "username", defaultValue = " ") String username,
                          @RequestParam(value = "password", defaultValue = " ") String password,
                          @RequestParam(value = "email", defaultValue = " ") String email) {

        if (!username.contains(" ")&&!password.contains(" ")){ userService.addUser(username, PasswordEncoderGenerator.encode(password),email); return "redirect:/";}
        else return "register";
    }

    /**
     * Metoda ta zwraca formularz logowania
     * @return Formularz logowania
     */
    @RequestMapping(value={"/login"})
    public String login(){
        return "login";
    }

    /**
     * Metoda ta obsługuje wysłanie danych z formularza logowania
     * @return Po pomyślnym zalogowaniu zwracany jest widok strony głównej
     */
    @RequestMapping(value={"/login"},method=RequestMethod.POST)
    public String loged(){
        return "redirect:/";
    }
    @GetMapping("/mytutorials")
    public String getAllUserTutorials(HttpServletRequest request,Model model){
        try {
            Principal principal = request.getUserPrincipal();
            System.out.println(principal.getName());
            int id=userService.getUserByName(principal.getName());
            System.out.println(id);
            int size=this.tutorialService.getAllUserTut(id).size();
            if (size>0){
                model.addAttribute("tutorials",this.tutorialService.getAllUserTut(id));
            }else{
                ArrayList<Tutorial> tut=new ArrayList<>();
                Tutorial tutNotFound=new Tutorial(0,"","Brak utworzonych kursów","","notFoundTut.jpg",0,0,0,0);
                tut.add(tutNotFound);
                model.addAttribute("tutorials",tut);
            }
        }catch(Exception ex){
            System.out.println("anonymous");
        }
        return "mytutorials";
    }
}
