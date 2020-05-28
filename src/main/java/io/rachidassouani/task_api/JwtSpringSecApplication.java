package io.rachidassouani.task_api;

import io.rachidassouani.task_api.dao.TaskRepository;
import io.rachidassouani.task_api.entity.AppRole;
import io.rachidassouani.task_api.entity.AppUser;
import io.rachidassouani.task_api.entity.Task;
import io.rachidassouani.task_api.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.stream.Stream;

@SpringBootApplication
public class JwtSpringSecApplication implements CommandLineRunner {
	@Autowired
	private TaskRepository taskRepository;
	@Autowired
	private AccountService accountService;

	public static void main(String[] args) {
		SpringApplication.run(JwtSpringSecApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		Stream.of("Task1", "Task2", "Task3")
				.forEach(taskName -> {
					taskRepository.save(new Task(taskName));
				});
		accountService.saveUser(new AppUser("admin", "1234"));
		accountService.saveUser(new AppUser("user", "1234"));

		accountService.saveRole(new AppRole("ADMIN"));
		accountService.saveRole(new AppRole("USER"));

		accountService.addRoleToUser("admin", "ADMIN");
		accountService.addRoleToUser("admin", "USER");

		accountService.addRoleToUser("user", "USER");

	}
}
