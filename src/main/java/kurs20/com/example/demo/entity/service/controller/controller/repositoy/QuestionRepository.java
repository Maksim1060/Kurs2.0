package kurs20.com.example.demo.entity.service.controller.controller.repositoy;

import kurs20.com.example.demo.entity.Question;

import java.util.Collection;

public interface QuestionRepository {
    Question add(Question question);

    Question remove(Question question);

    Collection<Question> getAll();



}
