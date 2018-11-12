package com.mszal.tutor.Entity;

/**
 * Created by Mateusz on 2018-11-05.
 */
public class Tutorial {
    private int tutId;
    private String subDate;
    private String name;
    private String description;
    private String imgName;
    private int marks;
    private int opinionCounts;
    private int userId;
    private int catId;
    private String status;


    public Tutorial() {

    }

    public Tutorial(int tutId, String subDate, String name, String description, String imgName, int marks, int opinionCounts, int userId, int catId, String status) {
        this.tutId = tutId;
        this.subDate = subDate;
        this.name = name;
        this.description = description;
        this.imgName = imgName;
        this.marks = marks;
        this.opinionCounts = opinionCounts;
        this.userId = userId;
        this.catId = catId;
        this.status = status;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public int getTutId() {
        return tutId;
    }

    public void setTutId(int tutId) {
        this.tutId = tutId;
    }

    public String getSubDate() {
        return subDate;
    }

    public void setSubDate(String subDate) {
        this.subDate = subDate;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getImgName() {
        return imgName;
    }

    public void setImgName(String imgName) {
        this.imgName = imgName;
    }

    public int getMarks() {
        return marks;
    }

    public void setMarks(int marks) {
        this.marks = marks;
    }

    public int getOpinionCounts() {
        return opinionCounts;
    }

    public void setOpinionCounts(int opinionCounts) {
        this.opinionCounts = opinionCounts;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public int getCatId() {
        return catId;
    }

    public void setCatId(int catId) {
        this.catId = catId;
    }

}
