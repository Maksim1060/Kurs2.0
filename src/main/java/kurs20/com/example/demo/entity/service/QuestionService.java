package kurs20.com.example.demo.entity.service;

import kurs20.com.example.demo.entity.JavaQuestionService;

import java.util.Collection;

public interface QuestionService {
    JavaQuestionService add(String question, String answer);

    JavaQuestionService add(JavaQuestionService question);

    JavaQuestionService remove(String question, String answer);
    Collection <JavaQuestionService> getAll();
    JavaQuestionService getRandomQuestion();
}
