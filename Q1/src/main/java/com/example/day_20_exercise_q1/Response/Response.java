package com.example.day_20_exercise_q1.Response;

import com.example.day_20_exercise_q1.Model.Task;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.ArrayList;

@Data
@AllArgsConstructor
public class Response {
    private String message;
    private Task task;

    public Response(String message) {
        this.message = message;
    }

    public Response(Task task) {
        this.task = task;
    }

}
