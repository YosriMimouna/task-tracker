package com.blockchaincomputing.tasktracker;

import com.blockchaincomputing.tasktracker.model.LocalTask;
import com.blockchaincomputing.tasktracker.repository.LocalTaskRepository;
import com.blockchaincomputing.tasktracker.service.LocalTaskService;
import com.mongodb.BasicDBObjectBuilder;
import com.mongodb.DBObject;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.data.mongo.DataMongoTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.Date;
import java.util.Optional;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

@DataMongoTest
@ExtendWith(SpringExtension.class)
class TaskTrackerApplicationTests {

	long currentCount;

	@Autowired
	LocalTaskRepository localTaskRepository;


	@Test
	public void testMongoIntegration(@Autowired MongoTemplate mongoTemplate) {
		LocalTask newTask = mongoTemplate.save(new LocalTask(new Date()), "LocalTask");
		// then
		assertThat(mongoTemplate.findAll(LocalTask.class, "LocalTask").get(0)).isEqualTo(newTask);
	}

	/*@Autowired
	LocalTaskService localTaskService;*/

	/*@Test
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
	}*/
}
