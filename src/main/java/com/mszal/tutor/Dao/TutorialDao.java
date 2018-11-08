package com.mszal.tutor.Dao;

import com.mszal.tutor.Entity.Tutorial;

import java.util.Collection;

/**
 * Created by Mateusz on 2018-11-05.
 */
public interface TutorialDao {
    Collection<Tutorial> getAllUserTut(int userId);
    Collection<Tutorial> getAllTutorial();
    void addTutorial(String name,String desc,String imgUrl,int userId,int catId);
}
