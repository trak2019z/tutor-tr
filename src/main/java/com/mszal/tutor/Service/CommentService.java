package com.mszal.tutor.Service;

import com.mszal.tutor.Dao.CommentDao;
import com.mszal.tutor.Entity.Comment;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by Mateusz on 2018-11-11.
 */
@Service
public class CommentService {
    @Autowired
    private CommentDao commentDao;
    public void addComment(String content, int userId, int subTutId){
        this.commentDao.addComment(content,userId,subTutId);
    }
    public List<Comment> getComments(int subTutId){
        return this.commentDao.getComments(subTutId);
    }
    public void deleteComment(int commId){
        this.commentDao.deleteComment(commId);
    }
}
