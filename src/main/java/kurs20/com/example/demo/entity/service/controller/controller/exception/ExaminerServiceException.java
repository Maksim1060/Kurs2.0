package kurs20.com.example.demo.entity.service.controller.controller.exception;

import jdk.jfr.StackTrace;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.BAD_REQUEST)
public class ExaminerServiceException extends RuntimeException{
    public ExaminerServiceException(String message) {
        super(message);
    }
}
