package io.rachidassouani.task_api.dao;

import io.rachidassouani.task_api.entity.Task;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TaskRepository extends JpaRepository<Task, Long> {
}
