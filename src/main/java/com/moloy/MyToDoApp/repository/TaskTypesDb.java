package com.moloy.MyToDoApp.repository;

import com.moloy.MyToDoApp.model.TaskTypes;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TaskTypesDb extends JpaRepository<TaskTypes, Integer> {

}
