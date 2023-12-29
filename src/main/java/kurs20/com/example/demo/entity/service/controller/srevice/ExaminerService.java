package kurs20.com.example.demo.entity.service.controller.srevice;

import kurs20.com.example.demo.entity.Question;

import java.util.Collection;

public interface ExaminerService {
    Collection<Question> getQuestions(int size);


}
