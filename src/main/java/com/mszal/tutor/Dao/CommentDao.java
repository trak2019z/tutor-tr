package com.mszal.tutor.Dao;

import com.mszal.tutor.Entity.Comment;

import java.util.List;

/**
 * Created by Mateusz on 2018-11-11.
 */
public interface CommentDao {
    void addComment(String content, int userId, int subTutId);
    List<Comment> getComments(int subTutId);
}
