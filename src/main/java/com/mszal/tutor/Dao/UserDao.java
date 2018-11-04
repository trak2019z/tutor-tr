package com.mszal.tutor.Dao;

/**
 * Created by Mateusz on 2018-11-04.
 */
public interface UserDao {
    /**
     * Metoda ta dodaje nowego użytkownika
     * @param username Nazwa użytkownika (login)
     * @param password Hasło użytkownika
     * @param email Email użytkownika
     */
    void addUser(String username, String password,String email);

    /**
     * Metoda ta zwraca użytkownika przez nazwę (login)
     * @param name Nazwa użytkownika (login)
     * @return Uzytkownik o określonej nazwie
     */
    int getUserByName(String name);
}
