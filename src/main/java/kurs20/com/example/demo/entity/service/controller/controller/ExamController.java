package kurs20.com.example.demo.entity.service.controller.controller;

import kurs20.com.example.demo.entity.JavaQuestionService;
import kurs20.com.example.demo.entity.service.controller.srevice.ExaminerService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collection;

@RestController
@RequestMapping("/exam")
public class ExamController {
    private final ExaminerService examinerService;

    public ExamController(ExaminerService examinerService) {
        this.examinerService = examinerService;
    }

    @GetMapping("/get/{amount}")
    public Collection<JavaQuestionService> getQuestions(@PathVariable int amount) {
        return examinerService.getQuestions(amount);
    }
}
