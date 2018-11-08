package com.mszal.tutor.Dao;

import com.mszal.tutor.Entity.Tutorial;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.Collection;

/**
 * Created by Mateusz on 2018-11-05.
 */
@Repository
public class TutorialDaoImpl implements TutorialDao {
    @Autowired
    private JdbcTemplate jdbcTemplate;
    @Override
    public Collection<Tutorial> getAllUserTut(int userId) {
        final String sql="Select * from tutorial Where userId=?";
        Collection<Tutorial> tutorials=jdbcTemplate.query(sql,new BeanPropertyRowMapper(Tutorial.class), userId);
        return tutorials;
    }

    @Override
    public Collection<Tutorial> getAllTutorial() {
        final String sql="Select * from tutorial";
        Collection<Tutorial> tutorials=jdbcTemplate.query(sql,new BeanPropertyRowMapper(Tutorial.class));
        return tutorials;
    }

    @Override
    public void addTutorial(String name, String desc, String imgUrl,int userId, int catId) {
        final String sql="Insert Into tutorial (name,description,imgName,userId,catId) Values (?,?,?,?,?)";
        jdbcTemplate.update(sql,new Object[]{name,desc,imgUrl,userId,catId});
    }
}
