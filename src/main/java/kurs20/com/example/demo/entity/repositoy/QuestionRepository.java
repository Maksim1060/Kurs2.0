package kurs20.com.example.demo.entity.repositoy;

import kurs20.com.example.demo.entity.Question;
import org.springframework.stereotype.Repository;

import java.util.Collection;
@Repository
public interface QuestionRepository {
    Question add(Question question);

    Question remove(Question question);

    Collection<Question> getAll();



}
