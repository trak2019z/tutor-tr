package com.mszal.tutor.Dao;

import com.mszal.tutor.Entity.Comment;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

/**
 * Created by Mateusz on 2018-11-11.
 */
@Repository
public class CommentDaoImpl implements CommentDao{
    @Autowired
    private JdbcTemplate jdbc;
    @Override
    public void addComment(String content, int userId, int subTutId) {
        final String sql="Insert Into comment (content,userId,subTutId) Values (?,?,?)";
        jdbc.update(sql,new Object[]{content,userId,subTutId});
    }

    @Override
    public List<Comment> getComments(int subTutId) {
        final String sql="Select * From comment Where subTutId=? Order By subDate DESC";
        List<Comment> comments=jdbc.query(sql,new BeanPropertyRowMapper<>(Comment.class),subTutId);
        return comments;
    }

    @Override
    public void deleteComment(int commId) {
        final String message="Komentarz został usunięty z powodu naruszenia regulaminu";
        final String sql="Update comment Set content=?,userId=0 Where commentId=?";
        jdbc.update(sql,new Object[]{message,commId});
    }
}
