package io.rachidassouani.task_api.web;

import io.rachidassouani.task_api.dao.TaskRepository;
import io.rachidassouani.task_api.entity.Task;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("tasks")
public class TaskRestController {

    private TaskRepository taskRepository;

    @Autowired
    public TaskRestController(TaskRepository taskRepository) {
        this.taskRepository = taskRepository;
    }

    @GetMapping
    public List<Task> findAllTasks() {
        return taskRepository.findAll();
    }

    @PostMapping
    public Task saveTask(@RequestBody Task task) {
        return taskRepository.save(task);
    }
}
