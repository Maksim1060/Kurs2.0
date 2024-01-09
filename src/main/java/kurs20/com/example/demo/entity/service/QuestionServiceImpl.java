package kurs20.com.example.demo.entity.service;

import kurs20.com.example.demo.entity.Question;
import kurs20.com.example.demo.entity.exception.ExaminerServiceException;
import kurs20.com.example.demo.entity.repositoy.QuestionRepository;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class QuestionServiceImpl implements QuestionService {
    private final QuestionRepository questionRepository;

    public QuestionServiceImpl(@Qualifier("javaQuestionRepository") QuestionRepository questionRepository) {
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
        Collection<Question>questions=questionRepository.getAll();
        int randomInx = new Random().nextInt(questions.size());
        return new ArrayList<>(questions).get(randomInx);

    }

    @Service

    public static class ExaminerServiceImpl implements ExaminerService {
        private final QuestionService javaQuestionService;
        private final QuestionService mathQuestionService;

        public ExaminerServiceImpl(@Qualifier("questionQuestionService") QuestionService javaQuestionService,
                                   @Qualifier("mathQuestionService") QuestionService mathQuestionService) {
            this.javaQuestionService = javaQuestionService;
            this.mathQuestionService = mathQuestionService;
        }

        @Override
        public Collection<Question> getQuestions(int size) {
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
}
