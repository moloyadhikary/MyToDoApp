package com.moloy.MyToDoApp.repository;

import com.moloy.MyToDoApp.model.SubTaskDetails;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SubTaskDetailsDb extends JpaRepository<SubTaskDetails, Integer> {
}
