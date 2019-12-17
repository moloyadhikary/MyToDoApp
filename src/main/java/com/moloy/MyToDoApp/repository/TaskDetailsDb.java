package com.moloy.MyToDoApp.repository;

import com.moloy.MyToDoApp.model.TaskDetails;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

public interface TaskDetailsDb extends JpaRepository<TaskDetails, Integer> {
    //List<TaskDetails> findBytask_name(String task_name);
    //List<TaskDetails> findByTask_idGreaterThan(int task_id);

//    @Query("from TaskDetails where task_name=?1 order by task_name")
//    List<TaskDetails> findByTask_NameSorted(String task_name);

    @Query("FROM TaskDetails WHERE is_completed = ?1 order by task_id DESC")
    List<TaskDetails> findByIs_completedFalse(boolean is_completed);

    @Query("FROM TaskDetails WHERE is_completed = ?1 and task_type_task_type_id=?2 order by task_id DESC")
    List<TaskDetails> findByIs_completedAAndTask_type(boolean is_completed, Optional<Integer> task_type);
}
