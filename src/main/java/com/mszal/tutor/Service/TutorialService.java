package com.mszal.tutor.Service;

import com.mszal.tutor.Dao.TutorialDao;
import com.mszal.tutor.Entity.Tutorial;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collection;

/**
 * Created by Mateusz on 2018-11-05.
 */
@Service
public class TutorialService {
    @Autowired
    private TutorialDao tutorialDao;

    public Collection<Tutorial> getAllUserTut(int userId){
        return this.tutorialDao.getAllUserTut(userId);
    }
    public Collection<Tutorial> getAllTutorials(){
        return this.tutorialDao.getAllTutorial();
    }
    public void addTutorial(String name,String desc,String imgUrl,int userId,int catId){
        this.tutorialDao.addTutorial(name,desc,imgUrl,userId,catId);
    }
}
