package kurs20.com.example.demo.entity.service;

import kurs20.com.example.demo.entity.Question;
import kurs20.com.example.demo.entity.repositoy.JavaQuestionRepository;
import kurs20.com.example.demo.entity.repositoy.QuestionRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Collection;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
@ExtendWith(MockitoExtension.class)
class QuestionServiceImplTest {
    @Mock(name="javaQuestionService")
    private JavaQuestionRepository javaQuestionRepository;
    @InjectMocks
    private QuestionServiceImpl questionService;



    @Test
    void add() {
        String answer = "answer";
        String question = "question";
        Question expected = new Question(question, answer);
        when(javaQuestionRepository.add(eq(expected))).thenReturn(expected);
        Question actual = questionService.add(question, answer);
        assertEquals(expected, actual);
        verify(javaQuestionRepository).add(expected);
    }

    @Test
    void testAdd() {
        String answer = "answer";
        String question = "question";
        Question expected = new Question(question, answer);
        when(javaQuestionRepository.add(eq(expected))).thenReturn(expected);
        Question actual = questionService.add(question, answer);
        assertEquals(expected, actual);
        verify(javaQuestionRepository).add(expected);

    }

    @Test
    void remove() {
        String answer = "answer";
        String question = "question";
        Question expected = new Question(question, answer);
        when(javaQuestionRepository.remove(eq(expected))).thenReturn(expected);
        Question actual = questionService.remove(question, answer);
        assertEquals(expected, actual);
        verify(javaQuestionRepository).remove(expected);
    }

    @Test
    void getAll() {
        Collection<Question> actual = questionService.getAll();
        assertNotNull(actual);




    }

    @Test
    void getRandomQuestion() {
        Collection<Question>questions=javaQuestionRepository.getAll();
        assertNotNull(questions);



    }
}