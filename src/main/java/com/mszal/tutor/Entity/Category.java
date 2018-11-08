package com.mszal.tutor.Entity;

/**
 * Created by Mateusz on 2018-11-08.
 */
public class Category {
    private int categoryId;
    private String catName;

    public Category() {
    }

    public Category(int categoryId, String catName) {
        this.categoryId = categoryId;
        this.catName = catName;
    }

    public int getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(int categoryId) {
        this.categoryId = categoryId;
    }

    public String getCatName() {
        return catName;
    }

    public void setCatName(String catName) {
        this.catName = catName;
    }
}
