package com.blockchaincomputing.tasktracker;

import com.blockchaincomputing.tasktracker.model.LocalTask;
import com.blockchaincomputing.tasktracker.repository.LocalTaskRepository;
import com.blockchaincomputing.tasktracker.service.LocalTaskService;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Optional;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

@SpringBootTest
class TaskTrackerApplicationTests {

	long currentCount;

	@Autowired
	LocalTaskRepository localTaskRepository;

	@Autowired
	LocalTaskService localTaskService;

	@Test
	void testAddLocalTask() {
		LocalTask newTask = localTaskService.createTask();
		Optional<LocalTask> addedTask = localTaskRepository.findById(newTask.getId());
		assert addedTask.isPresent();
	}

	@Test
	void testCountIncrement() {
		this.currentCount = localTaskService.getTaskCount();
		LocalTask newTask = localTaskService.createTask();
		this.currentCount++;
		assertThat(localTaskService.getTaskCount()).isEqualTo(this.currentCount);
	}
}
