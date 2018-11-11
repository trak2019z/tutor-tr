package com.mszal.tutor.Entity;

/**
 * Created by Mateusz on 2018-11-11.
 */
public class Comment {
    private int commentId;
    private String content;
    private String subDate;
    private int userId;
    private int subTutId;

    public Comment() {
    }

    public Comment(int commentId, String content, String subDate, int userId, int subTutId) {
        this.commentId = commentId;
        this.content = content;
        this.subDate = subDate;
        this.userId = userId;
        this.subTutId = subTutId;
    }

    public int getCommentId() {
        return commentId;
    }

    public void setCommentId(int commentId) {
        this.commentId = commentId;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getSubDate() {
        return subDate;
    }

    public void setSubDate(String subDate) {
        this.subDate = subDate;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public int getSubTutId() {
        return subTutId;
    }

    public void setSubTutId(int subTutId) {
        this.subTutId = subTutId;
    }
}
