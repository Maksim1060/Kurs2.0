package kurs20.com.example.demo.entity.service.controller.srevice;

import kurs20.com.example.demo.entity.JavaQuestionService;

import java.util.Collection;

public interface ExaminerService {
    Collection<JavaQuestionService> getQuestions(int size);


}
