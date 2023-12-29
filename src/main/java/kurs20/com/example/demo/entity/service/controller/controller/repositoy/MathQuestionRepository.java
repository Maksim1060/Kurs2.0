package kurs20.com.example.demo.entity.service.controller.controller.repositoy;

import kurs20.com.example.demo.entity.Question;

import java.util.Collection;
import java.util.HashSet;

public class MathQuestionRepository implements QuestionRepository {
    private final Collection<Question> questions = new HashSet<>();
    @Override
    public Question add(Question question) {
        questions.add(question);
        return question;
    }

    @Override
    public Question remove(Question question) {
        questions.remove(question);
        return question;
    }

    @Override
    public Collection<Question> getAll() {
        return questions;
    }
}
