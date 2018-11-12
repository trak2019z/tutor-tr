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
        final String sql="Select * from tutorial Where userId=? And status='unlock'";
        Collection<Tutorial> tutorials=jdbcTemplate.query(sql,new BeanPropertyRowMapper(Tutorial.class), userId);
        return tutorials;
    }

    @Override
    public Collection<Tutorial> getAllTutorial() {
        //final String sql="Select * from tutorial";
        final String sql="select * from tutorial t where t.tutId in (select s.idTut from subtutorial s) And t.status='unlock'";
        Collection<Tutorial> tutorials=jdbcTemplate.query(sql,new BeanPropertyRowMapper(Tutorial.class));
        return tutorials;
    }

    @Override
    public void addTutorial(String name, String desc, String imgUrl,int userId, int catId) {
        final String sql="Insert Into tutorial (name,description,imgName,userId,catId) Values (?,?,?,?,?)";
        jdbcTemplate.update(sql,new Object[]{name,desc,imgUrl,userId,catId});
    }

    @Override
    public Collection<Tutorial> getAllBlockedTut() {
        final String sql="select * from tutorial t where t.tutId in (select s.idTut from subtutorial s) And t.status='block'";
        Collection<Tutorial> tutorials=jdbcTemplate.query(sql,new BeanPropertyRowMapper(Tutorial.class));
        return tutorials;
    }

    @Override
    public void blockTutorial(int tutId) {
        final String sql="Update tutorial Set status='block' Where tutId=?";
        jdbcTemplate.update(sql,new Object[]{tutId});
    }

    @Override
    public void unlockTutorial(int tutId) {
        final String sql="Update tutorial Set status='unlock' Where tutId=?";
        jdbcTemplate.update(sql,new Object[]{tutId});
    }
}
