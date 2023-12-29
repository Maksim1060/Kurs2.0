package kurs20.com.example.demo.entity.service.controller.controller.repositoy;

import kurs20.com.example.demo.entity.JavaQuestionService;

import java.util.Collection;

public interface QuestionRepository {
    JavaQuestionService add(JavaQuestionService question);

    JavaQuestionService remove(JavaQuestionService question);

    Collection<JavaQuestionService> getAll();



}
