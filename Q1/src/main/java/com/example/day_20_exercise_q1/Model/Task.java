package com.example.day_20_exercise_q1.Model;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Task {
    private int id;
    private String title;
    private String description;
    private String status;

}