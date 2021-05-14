package com.blockchaincomputing.tasktracker.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Date;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Document(collection = "LocalTask")
public class LocalTask {

    @Id
    private String id;
    private Date addDate;

    public LocalTask(Date date) {
        this.addDate = date;
    }
}
