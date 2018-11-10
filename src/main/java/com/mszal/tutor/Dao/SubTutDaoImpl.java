package com.mszal.tutor.Dao;

import com.mszal.tutor.Entity.SubTutorial;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

/**
 * Created by Mateusz on 2018-11-10.
 */
@Repository
public class SubTutDaoImpl implements SubTutDao {
    @Autowired
    private JdbcTemplate jdbc;
    @Override
    public void addsubTut(String subj, String cont, int lessNumb, int idTut) {
        final String sql="Insert Into subtutorial (subject,content,lessNumb,idTut) Values (?,?,?,?)";
        jdbc.update(sql,new Object[]{subj,cont,lessNumb,idTut});

    }

    @Override
    public int checkLessonCount(int idTut) {
        final String sql="SELECT count(*) from subtutorial WHERE idTut=?";
        int lessCount=jdbc.queryForObject(sql,new Object[]{idTut},Integer.class);
        return lessCount;
    }

    @Override
    public List<SubTutorial> getAllLessons(int tutId) {
        final String sql="Select subTutId, subject,lessNumb From subtutorial Where idTut=? Order By lessNumb ASC";
        List<SubTutorial> lessons=jdbc.query(sql,new Object[]{tutId}, new RowMapper<SubTutorial>() {
            @Override
            public SubTutorial mapRow(ResultSet resultSet, int i) throws SQLException {
                SubTutorial lesson=new SubTutorial();
                lesson.setSubTutId(resultSet.getInt("subTutId"));
                lesson.setSubject(resultSet.getString("subject"));
                lesson.setLessNumb(resultSet.getInt("lessNumb"));
                return lesson;
            }
        });
        return lessons;
    }

    @Override
    public SubTutorial getEntireLesson(int tutId, int lessNumb) {
        final String sql="Select * From subtutorial Where idTut=? And lessNumb=?";
        //SubTutorial entLesson=jdbc.queryForObject(sql,new Object[]{tutId,lessNumb},SubTutorial.class);
        SubTutorial entLesson=jdbc.queryForObject(sql,new Object[]{tutId,lessNumb},new BeanPropertyRowMapper<>(SubTutorial.class));
        return entLesson;
    }
}
