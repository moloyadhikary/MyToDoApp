package com.moloy.MyToDoApp.model;

import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.time.LocalDateTime;

@Entity
public class SubTaskDetails {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "native")
    private int id;

    @Column(length = 200)
    @NotNull
    private String st_text;

    @Column(length = 20)
    private String st_status;

    @Column(length = 200)
    private String st_description;

    @CreationTimestamp
    private LocalDateTime st_added_date;

    @ManyToOne
    @JoinColumn
    private TaskDetails parentTask;


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getSt_text() {
        return st_text;
    }

    public void setSt_text(String st_text) {
        this.st_text = st_text;
    }

    public String getSt_status() {
        return st_status;
    }

    public void setSt_status(String st_status) {
        this.st_status = st_status;
    }

    public String getSt_description() {
        return st_description;
    }

    public void setSt_description(String st_description) {
        this.st_description = st_description;
    }

    public LocalDateTime getSt_added_date() {
        return st_added_date;
    }

    public void setSt_added_date(LocalDateTime st_added_date) {
        this.st_added_date = st_added_date;
    }

    public TaskDetails getParentTask() {
        return parentTask;
    }

    public void setParentTask(TaskDetails parentTask) {
        this.parentTask = parentTask;
    }
}
