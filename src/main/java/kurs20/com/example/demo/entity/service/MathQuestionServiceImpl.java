package kurs20.com.example.demo.entity.service;

import kurs20.com.example.demo.entity.JavaQuestionService;
import kurs20.com.example.demo.entity.service.controller.controller.repositoy.QuestionRepository;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Random;

@Service
public class MathQuestionServiceImpl implements QuestionService {
    private final QuestionRepository questionRepository;

    public MathQuestionServiceImpl(@Qualifier(" mathQuestionRepository") QuestionRepository questionRepository) {
        this.questionRepository = questionRepository;
    }

    @Override
    public JavaQuestionService add(String question, String answer) {
        JavaQuestionService newQuestion = new JavaQuestionService(question, answer);
        questionRepository.add(newQuestion);
        return newQuestion;
    }

    @Override
    public JavaQuestionService add(JavaQuestionService question) {
        questionRepository.add(question);
        return question;
    }

    @Override
    public JavaQuestionService remove(String question, String answer) {
        JavaQuestionService questionForRemove = new JavaQuestionService(question, answer);
        questionRepository.remove(questionForRemove);
        return questionForRemove;
    }

    @Override
    public Collection<JavaQuestionService> getAll() {
        return questionRepository.getAll();
    }

    @Override
    public JavaQuestionService getRandomQuestion() {
        Collection<JavaQuestionService> questions=questionRepository.getAll();
        int randomInx = new Random().nextInt(questions.size());
        return new ArrayList<>(questions).get(randomInx);
    }
}
