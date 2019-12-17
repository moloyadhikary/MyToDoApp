package com.moloy.MyToDoApp.controller;

import com.moloy.MyToDoApp.repository.SubTaskDetailsDb;
import com.moloy.MyToDoApp.repository.TaskDetailsDb;
import com.moloy.MyToDoApp.repository.TaskTypesDb;
import org.springframework.beans.factory.annotation.Autowired;

public class BaseController {
    @Autowired
    TaskTypesDb _TaskTypesDb;

    @Autowired
    TaskDetailsDb _TaskDetailsDb;

    @Autowired
    SubTaskDetailsDb _SubTaskDetailsDb;
}
