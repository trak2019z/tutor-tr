package com.mszal.tutor.Entity;

/**
 * Created by Mateusz on 2018-11-04.
 */
public class User {
    private int userId;
    private String login;
    private String password;
    private String email;
    private String user_role;
    private short userStatus;

    public User(int userId, String login, String password, String email, String user_role, short userStatus) {
        this.userId = userId;
        this.login = login;
        this.password = password;
        this.email = email;
        this.user_role = user_role;
        this.userStatus = userStatus;
    }

    /**
     * Konstruktor bezparametrowy
     */
    public User() {
    }

    /**
     * Metoda ta zwraca id użytkownika
     *
     * @return Id użytkownika
     */
    public int getUserId() {
        return userId;
    }

    /**
     * Metoda ta ustawia id użytkownika
     *
     * @param userId Id użytkownika
     */
    public void setUserId(int userId) {
        this.userId = userId;
    }

    /**
     * Metoda ta zwraca login
     *
     * @return Login
     */
    public String getLogin() {
        return login;
    }

    /**
     * Metoda ta ustawia login
     *
     * @param login Login
     */
    public void setLogin(String login) {
        this.login = login;
    }

    /**
     * Metoda ta zwraca hasło
     *
     * @return Hasło
     */
    public String getPassword() {
        return password;
    }

    /**
     * Metoda ta ustawia hasło
     *
     * @param password Hasło
     */
    public void setPassword(String password) {
        this.password = password;
    }

    /**
     * Metoda ta zwraca email
     *
     * @return Email
     */
    public String getEmail() {
        return email;
    }

    /**
     * Metoda ta ustawia email
     *
     * @param email Email
     */
    public void setEmail(String email) {
        this.email = email;
    }

    /**
     * Metoda ta zwraca rolę użytkownika
     *
     * @return Rola użytkownika
     */
    public String getUser_role() {
        return user_role;
    }

    /**
     * Metoda ta ustawia rolę użytkownika
     *
     * @param user_role Rola użytkownika
     */
    public void setUser_role(String user_role) {
        this.user_role = user_role;
    }

    /**
     * Metoda ta zwraca status użytkownika
     *
     * @return Status użytkownika
     */
    public short getUserStatus() {
        return userStatus;
    }

    /**
     * Metoda ta ustawia status użytkownika
     *
     * @param userStatus Status użytkownika
     */
    public void setUserStatus(short userStatus) {
        this.userStatus = userStatus;
    }
}
