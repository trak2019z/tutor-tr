package com.mszal.tutor.Dao;

import com.mszal.tutor.Entity.Category;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Collection;

/**
 * Created by Mateusz on 2018-11-08.
 */
@Repository
public class CategoryDaoImpl implements CategoryDao {
    @Autowired
    private JdbcTemplate jdbc;
    @Override
    public Collection<Category> getAllCategories() {
        final String sql="Select * from category";
        Collection<Category> categories=jdbc.query(sql, new RowMapper<Category>() {
            @Override
            public Category mapRow(ResultSet resultSet, int i) throws SQLException {
                Category category=new Category();
                category.setCategoryId(resultSet.getInt("categoryId"));
                category.setCatName(resultSet.getString("categoryName"));
                return category;
            }
        });
        return categories;
    }

    @Override
    public int getCategoryId(String categoryName) {
        final String sql="Select categoryId From category Where categoryName=?";
        int catId=jdbc.queryForObject(sql,new Object[]{categoryName},Integer.class);
        return catId;
    }
}
