package kurs20.com.example.demo.entity.service.controller.srevice;

import kurs20.com.example.demo.entity.Question;
import kurs20.com.example.demo.entity.service.QuestionService;
import kurs20.com.example.demo.entity.service.controller.controller.exception.ExaminerServiceException;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.HashSet;
import java.util.concurrent.ExecutionException;

@Service

public class ExaminerServiceImpl implements ExaminerService {
    private final QuestionService questionService;

    public ExaminerServiceImpl(QuestionService questionService) {
        this.questionService = questionService;
    }

    @Override
    public Collection<Question> getQuestions(int size) {
        if (questionService.getAll().size() < size) {
            throw new ExaminerServiceException("Запрошено большое количество вопросов, чем хранится в сервисе");
        }
        Collection<Question> result = new HashSet<>();
        while (result.size() < size) {
            result.add(questionService.getRandomQuestion());
        }
        return result;
    }
}
