package kurs20.com.example.demo.entity.service;

import kurs20.com.example.demo.entity.Question;
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
    public Question add(String question, String answer) {
        Question newQuestion = new Question(question, answer);
        questionRepository.add(newQuestion);
        return newQuestion;
    }

    @Override
    public Question add(Question question) {
        questionRepository.add(question);
        return question;
    }

    @Override
    public Question remove(String question, String answer) {
        Question questionForRemove = new Question(question, answer);
        questionRepository.remove(questionForRemove);
        return questionForRemove;
    }

    @Override
    public Collection<Question> getAll() {
        return questionRepository.getAll();
    }

    @Override
    public Question getRandomQuestion() {
        Collection<Question> questions=questionRepository.getAll();
        int randomInx = new Random().nextInt(questions.size());
        return new ArrayList<>(questions).get(randomInx);
    }
}
