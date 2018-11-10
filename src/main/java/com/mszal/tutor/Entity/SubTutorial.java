package com.mszal.tutor.Entity;

/**
 * Created by Mateusz on 2018-11-10.
 */
public class SubTutorial {
    private int subTutId;
    private String subject;
    private String content;
    private int lessNumb;
    private String subDate;
    private int idTut;

    public SubTutorial() {
    }

    public SubTutorial(int subTutId, String subject, String content, int lessNumb, String subDate, int idTut) {
        this.subTutId = subTutId;
        this.subject = subject;
        this.content = content;
        this.lessNumb = lessNumb;
        this.subDate = subDate;
        this.idTut = idTut;
    }

    public int getSubTutId() {
        return subTutId;
    }

    public void setSubTutId(int subTutId) {
        this.subTutId = subTutId;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public int getLessNumb() {
        return lessNumb;
    }

    public void setLessNumb(int lessNumb) {
        this.lessNumb = lessNumb;
    }

    public String getSubDate() {
        return subDate;
    }

    public void setSubDate(String subDate) {
        this.subDate = subDate;
    }

    public int getIdTut() {
        return idTut;
    }

    public void setIdTut(int idTut) {
        this.idTut = idTut;
    }
}
