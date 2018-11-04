package com.mszal.tutor.Controller;
import com.mszal.tutor.Service.PasswordEncoderGenerator;
import com.mszal.tutor.Service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
/**
 * Created by Mateusz on 2018-11-04.
 */
@Controller
public class UserController {
    @Autowired
    private UserService userService;

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

        if (!username.contains(" ")&&!password.contains(" ")){ userService.addUser(username, PasswordEncoderGenerator.encode(password),email); return "redirect:/posts";}
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
}
