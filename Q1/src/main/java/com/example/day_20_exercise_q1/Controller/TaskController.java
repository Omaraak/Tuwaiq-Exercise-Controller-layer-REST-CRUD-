package com.example.day_20_exercise_q1.Controller;

import com.example.day_20_exercise_q1.Model.Task;
import com.example.day_20_exercise_q1.Response.Response;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Objects;

@RestController
@RequestMapping("api/v1/todo")
public class TaskController {

    ArrayList<Task> tasks = new ArrayList<>();

    @GetMapping("/display-all")
    public ArrayList<Task> displayAllTasks() {
        return tasks;
    }

    @GetMapping("/display-task/{title}")
    public Response displayTask(@PathVariable String title) {
        for (Task task : tasks) {
            if (task.getTitle().equals(title)) {
                return new Response(task);
            }
        }
        return new Response("Task not found");
    }

    @PutMapping("/update/{index}")
    public Response updateTask(@RequestBody Task task,@PathVariable int index) {
        if (index < tasks.size()) {
            tasks.set(index, task);
            return new Response("Task updated");
        }
        else
            return new Response("Index out of bounds");
    }

    @PutMapping("update-status")
    public Task updateTaskStatus(@RequestBody Task task) {
        for (Task t : tasks) {
            if (!task.getStatus().equals(t.getStatus()) && Objects.equals(task.getId(), t.getId()))
                t.setStatus(task.getStatus());
        }
        return task;
    }

    @DeleteMapping("/delete/{index}")
    public Response deleteTask(@PathVariable int index) {
        if (index < tasks.size()) {
            tasks.remove(index);
            return new Response("Task deleted successfully");
        }
        else
            return new Response("Task not found");
    }

    @PostMapping("/add")
    public Response addTask(@RequestBody Task task) {
        tasks.add(task);
        return new Response("Task added");
    }


}
