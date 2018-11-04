package com.mszal.tutor.Dao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;
/**
 * Created by Mateusz on 2018-11-04.
 */
@Repository
public class UserDaoImpl implements UserDao {
    @Autowired
    private JdbcTemplate jdbcTemplate;
    /**
     * Metoda ta dodaje nowego użytkownika
     * @param username Nazwa użytkownika (login)
     * @param password Hasło użytkownika
     * @param email Email użytkownika
     */
    @Override
    public void addUser(String username, String password, String email) {

        final String sql = "INSERT INTO user (login,password,email) VALUES (?,?,?)";
        jdbcTemplate.update(sql, new Object[]{username, password, email});

    }
    /**
     * Metoda ta zwraca użytkownika przez nazwę (login)
     * @param name Nazwa użytkownika (login)
     * @return Uzytkownik o określonej nazwie
     */
    @Override
    public int getUserByName(String name) {
        int id;

        final String sql = "SELECT userId FROM user WHERE login=?";
        id = jdbcTemplate.queryForObject(sql, new Object[]{name}, Integer.class);
        return id;


    }

}
