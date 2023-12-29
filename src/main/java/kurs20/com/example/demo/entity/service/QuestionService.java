package kurs20.com.example.demo.entity.service;

import kurs20.com.example.demo.entity.Question;

import java.util.Collection;

public interface QuestionService {
    Question add(String question, String answer);

    Question add(Question question);

    Question remove(String question, String answer);
    Collection <Question> getAll();
    Question getRandomQuestion();
}
