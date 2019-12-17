package com.moloy.MyToDoApp.model;


import javax.persistence.*;
import javax.validation.constraints.Max;
import javax.validation.constraints.NotNull;
import java.util.Set;

@Entity
public class TaskTypes {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "native")
    private int task_type_id;

    @NotNull
    @Column(length = 200)
    private String type_of_task;

    @OneToMany(mappedBy = "task_type", cascade = CascadeType.ALL)
    private Set<TaskDetails> taskDetailsSet;

    public int getTask_type_id() {
        return task_type_id;
    }

    public void setTask_type_id(int task_type_id) {
        this.task_type_id = task_type_id;
    }

    public String getType_of_task() {
        return type_of_task;
    }

    public void setType_of_task(String type_of_task) {
        this.type_of_task = type_of_task;
    }

    public Set<TaskDetails> getTaskDetailsSet() {
        return taskDetailsSet;
    }

    public void setTaskDetailsSet(Set<TaskDetails> taskDetailsSet) {
        this.taskDetailsSet = taskDetailsSet;
    }
}
