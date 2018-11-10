package com.mszal.tutor.Dao;

import com.mszal.tutor.Entity.SubTutorial;

import java.util.Collection;
import java.util.List;

/**
 * Created by Mateusz on 2018-11-10.
 */
public interface SubTutDao {
    void addsubTut(String subj, String cont, int lessNumb,int idTut);
    int checkLessonCount(int idTut);
    List<SubTutorial> getAllLessons(int tutId);
    SubTutorial getEntireLesson(int tutId,int lessNumb);
}
