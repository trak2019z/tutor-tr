package com.mszal.tutor.Dao;

import com.mszal.tutor.Entity.Category;

import java.util.Collection;

/**
 * Created by Mateusz on 2018-11-08.
 */
public interface CategoryDao {
    Collection<Category> getAllCategories();
    int getCategoryId(String categoryName);
}
