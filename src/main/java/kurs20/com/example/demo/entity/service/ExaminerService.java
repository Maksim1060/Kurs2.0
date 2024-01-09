package kurs20.com.example.demo.entity.service;

import kurs20.com.example.demo.entity.Question;

import java.util.Collection;

public interface ExaminerService {
    Collection<Question> getQuestion(int size);
}
