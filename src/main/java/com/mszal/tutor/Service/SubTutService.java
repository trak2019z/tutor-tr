package com.mszal.tutor.Service;

import com.mszal.tutor.Dao.SubTutDao;
import com.mszal.tutor.Entity.SubTutorial;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by Mateusz on 2018-11-10.
 */
@Service
public class SubTutService {
    @Autowired
    private SubTutDao subTutDao;

    public void addsubTut(String subj, String cont, int lessNumb, int idTut) {
        this.subTutDao.addsubTut(subj, cont, lessNumb, idTut);
    }

    public int checkLessonCount(int idTut) {
        return this.subTutDao.checkLessonCount(idTut);
    }

    public List<SubTutorial> getAllLessons(int tutId) {
        return this.subTutDao.getAllLessons(tutId);
    }
    public SubTutorial getEntireLesson(int tutId,int lessNumb){
        return this.subTutDao.getEntireLesson(tutId,lessNumb);
    }
    public int getLessonId(int tutId,int lessNumb){
        return this.subTutDao.getLessonId(tutId,lessNumb);
    }
}
