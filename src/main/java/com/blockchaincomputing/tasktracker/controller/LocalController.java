package com.blockchaincomputing.tasktracker.controller;


import com.blockchaincomputing.tasktracker.model.LocalTask;
import com.blockchaincomputing.tasktracker.service.LocalTaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/local/tasks")
public class LocalController {


    @Autowired
    LocalTaskService localTaskService;

    @PostMapping(value = "/")
    public ResponseEntity<LocalTask> createTask() {
        return ResponseEntity.ok(this.localTaskService.createTask());
    }

    @GetMapping(value = "/count")
    public ResponseEntity<Integer> getTaskCount() {
        return ResponseEntity.ok(this.localTaskService.getTaskCount());
    }
}
