package com.blockchaincomputing.tasktracker.service;

import com.blockchaincomputing.tasktracker.model.LocalTask;
import com.blockchaincomputing.tasktracker.repository.LocalTaskRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
@Slf4j
public class LocalTaskService {

    @Autowired
    private LocalTaskRepository localTaskRepository;

    /**
     * Creates LocalTask object and stores it in LocalTask collection
     * @return created LocalTask
     */
    public LocalTask createTask() {
        LocalTask newTask = localTaskRepository.save(new LocalTask(new Date()));
        log.info("new task created at: " + newTask.getAddDate());
        return newTask;
    }

    /**
     * Retrieves number of stored LocalTask objects
     * @return stored LocalTask objects count
     */
    public long getTaskCount() {
        return this.localTaskRepository.count();
    }
}
