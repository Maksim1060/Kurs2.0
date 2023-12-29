package kurs20.com.example.demo.entity.service.controller.controller.repositoy;

import kurs20.com.example.demo.entity.JavaQuestionService;

import java.util.Collection;
import java.util.HashSet;

public class JavaQuestionRepository implements QuestionRepository {
    private final Collection<JavaQuestionService> questions = new HashSet<>();
    @Override
    public JavaQuestionService add(JavaQuestionService question) {
        questions.add(question);
        return question;
    }

    @Override
    public JavaQuestionService remove(JavaQuestionService question) {
        questions.remove(question);
        return question;
    }

    @Override
    public Collection<JavaQuestionService> getAll() {
        return questions;
    }
}
