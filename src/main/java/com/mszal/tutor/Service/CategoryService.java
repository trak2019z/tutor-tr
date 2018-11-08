package com.mszal.tutor.Service;

import com.mszal.tutor.Dao.CategoryDao;
import com.mszal.tutor.Entity.Category;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collection;

/**
 * Created by Mateusz on 2018-11-08.
 */
@Service
public class CategoryService {
    @Autowired
    private CategoryDao categoryDao;

    public Collection<Category> getAllCategories(){
        return this.categoryDao.getAllCategories();
    }
    public int getCategoryId(String categoryName){
        return this.categoryDao.getCategoryId(categoryName);
    }
}
