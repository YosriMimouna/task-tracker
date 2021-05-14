package com.blockchaincomputing.tasktracker.service;

import com.blockchaincomputing.tasktracker.model.LocalTask;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
@Slf4j
public class LocalTaskService {

    private List<LocalTask> taskList;

    public LocalTaskService() {
        this.taskList = new ArrayList<>();
    }

    public LocalTask createTask() {
        LocalTask newTask = new LocalTask(new Date());
        this.taskList.add(newTask);
        log.info("new task created at: " + newTask.getAddDate());
        return newTask;
    }

    public int getTaskCount() {
        return this.taskList.size();
    }
}
