package kurs20.com.example.demo.entity.service;

import kurs20.com.example.demo.entity.Question;
import kurs20.com.example.demo.entity.exception.ExaminerServiceException;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.HashSet;
import java.util.Random;
@Service
public class ExaminerServiceImpl implements ExaminerService {
    private final QuestionService javaQuestionService;
    private final QuestionService mathQuestionService;

    public ExaminerServiceImpl(@Qualifier("questionQuestionService") QuestionService javaQuestionService,
                               @Qualifier("mathQuestionService") QuestionService mathQuestionService) {
        this.javaQuestionService = javaQuestionService;
        this.mathQuestionService = mathQuestionService;
    }

    @Override
    public Collection<Question> getQuestion(int size) {
        if (javaQuestionService.getAll().size() + mathQuestionService.getAll().size() < size) {
            throw new ExaminerServiceException("Запрошено большое количество вопросов, чем хранится в сервисе");
        }
        Collection<Question> result = new HashSet<>();
        while (result.size() < size) {
            if (new Random().nextBoolean()) {
                result.add(javaQuestionService.getRandomQuestion());
            } else {
                result.add(mathQuestionService.getRandomQuestion());
            }
        }
        return result;
    }
}