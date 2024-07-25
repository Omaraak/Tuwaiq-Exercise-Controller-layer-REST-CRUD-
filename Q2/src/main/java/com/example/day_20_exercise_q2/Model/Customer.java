package com.example.day_20_exercise_q2.Model;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Customer {
    private String userName;
    private int id,balance;
}
