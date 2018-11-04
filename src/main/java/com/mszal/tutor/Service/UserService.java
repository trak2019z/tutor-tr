package com.mszal.tutor.Service;
import com.mszal.tutor.Dao.UserDao;
import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
/**
 * Created by Mateusz on 2018-11-04.
 */
@Service
public class UserService {
    @Autowired
    UserDao userDao;

    /**
     * Metoda ta dodaje nowego użytkownika
     * @param username Nazwa użytkownika (login)
     * @param password Hasło użytkownika
     * @param email Email użytkownika
     */
    public void addUser(String username,String password,String email){
        userDao.addUser(username,password,email);
    }

    /**
     * Metoda ta zwraca id użytkownika o określonej nazwie (login)
     * @param name Nazwa użytkownika (login)
     * @return Id znalezionego użytkownika
     */
    public int getUserByName(String name){
        return this.userDao.getUserByName(name);
    }
}
