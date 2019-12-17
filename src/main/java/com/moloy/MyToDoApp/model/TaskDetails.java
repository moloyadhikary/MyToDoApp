package com.moloy.MyToDoApp.model;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.GeneratorType;
import org.hibernate.annotations.ManyToAny;
import org.hibernate.annotations.SortComparator;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.lang.annotation.Native;
import java.time.LocalDateTime;
import java.util.Set;

@Entity
public class TaskDetails {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "native")
    private int task_id;

    @CreationTimestamp
    private LocalDateTime added_date;

    @NotNull
    @Column(length = 200, unique = true)
    private String task_name;

    @Column(length = 500)
    private String task_description;
    private boolean is_completed = false;

    private LocalDateTime completed_date;

    @ManyToOne
    @JoinColumn
    private TaskTypes task_type;


    @OneToMany(mappedBy = "parentTask", cascade = CascadeType.ALL)
    @OrderBy("id DESC")
    private Set<SubTaskDetails> subTasks;

    public int getTask_id() {
        return task_id;
    }

    public void setTask_id(int task_id) {
        this.task_id = task_id;
    }

    public LocalDateTime getAdded_date() {
        return added_date;
    }

    public void setAdded_date(LocalDateTime added_date) {
        this.added_date = added_date;
    }

    public String getTask_name() {
        return task_name;
    }

    public void setTask_name(String task_name) {
        this.task_name = task_name;
    }

    public String getTask_description() {
        return task_description;
    }

    public void setTask_description(String task_description) {
        this.task_description = task_description;
    }

    public boolean isIs_completed() {
        return is_completed;
    }

    public void setIs_completed(boolean is_completed) {
        this.is_completed = is_completed;
    }

    public LocalDateTime getCompleted_date() {
        return completed_date;
    }

    public void setCompleted_date(LocalDateTime completed_date) {
        this.completed_date = completed_date;
    }

    public TaskTypes getTask_type() {
        return task_type;
    }

    public void setTask_type(TaskTypes task_type) {
        this.task_type = task_type;
    }

    public Set<SubTaskDetails> getSubTasks() {
        return subTasks;
    }

    public void setSubTasks(Set<SubTaskDetails> subTasks) {
        this.subTasks = subTasks;
    }

    @Override
    public String toString() {
        return "TaskDetails{" +
                "task_id=" + task_id +
                ", task_name='" + task_name + '\'' +
                ", task_description='" + task_description + '\'' +
                '}';
    }
}
