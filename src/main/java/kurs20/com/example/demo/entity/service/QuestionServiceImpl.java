package kurs20.com.example.demo.entity.service;

import kurs20.com.example.demo.entity.Question;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class QuestionServiceImpl implements QuestionService {
    private final Collection<Question> questions = new HashSet<>();
    @Override
    public Question add(String question, String answer) {
        Question newQuestion = new Question(question, answer);
        questions.add(newQuestion);
        return newQuestion;
    }

    @Override
    public Question add(Question question) {
        questions.add(question);
        return question;
    }

    @Override
    public Question remove(String question, String answer) {
        Question questionForRemove = new Question(question, answer);
        questions.remove(question);
        return questionForRemove;

    }

    @Override
    public Collection<Question> getAll() {
        return questions;
    }

    @Override
    public Question getRandomQuestion() {
        int randomInx = new Random().nextInt(questions.size());
        return new ArrayList<>(questions).get(randomInx);

    }
}
