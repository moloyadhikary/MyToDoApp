package com.moloy.MyToDoApp.controller;

import com.moloy.MyToDoApp.model.TaskDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.sql.Date;
import java.time.LocalDateTime;

@Controller
@RequestMapping("/task/")
public class TaskController extends BaseController {

    @PostMapping("addNewTask")
    public String addNewTask(TaskDetails model){
        _TaskDetailsDb.save(model);
        return "redirect:/home";
    }

    @RequestMapping("getTaskDetails")
    public ModelAndView getTaskDetailsByTaskID(@RequestParam int task_id){
        ModelAndView mv = new ModelAndView("task/taskdetails");
        TaskDetails task = _TaskDetailsDb.findById(task_id).orElse(new TaskDetails());
        mv.addObject("model", task);

        return mv;
    }

    @RequestMapping("completedTasks")
    public ModelAndView completedTasks(){
        ModelAndView mv = new ModelAndView("/task/completedTasks");
        mv.addObject("completedTasks", _TaskDetailsDb.findByIs_completedFalse(true));

        return mv;
    }

    @GetMapping("editTask/{task_id}")
    public ModelAndView editTask(@PathVariable("task_id") Integer id){
        TaskDetails task = _TaskDetailsDb.findById(id).orElse(new TaskDetails());
        ModelAndView mv = new ModelAndView("/task/editTask");
        mv.addObject("taskTypes", _TaskTypesDb.findAll());
        mv.addObject("model", task);
        return mv;
    }

    @PostMapping("editTaskPost")
    public  String editTaskPost(TaskDetails model){
        TaskDetails extModel = _TaskDetailsDb.findById(model.getTask_id()).orElse(new TaskDetails());
        extModel.setTask_type(model.getTask_type());
        extModel.setTask_name(model.getTask_name());
        extModel.setTask_description(model.getTask_description());
        _TaskDetailsDb.save(extModel);
        return "redirect:/home";
    }

    @GetMapping("taskCompleted/{task_id}")
    public String taskCompleted(@PathVariable("task_id") Integer id){
        TaskDetails task = _TaskDetailsDb.findById(id).orElse(new TaskDetails());
        task.setIs_completed(true);
        task.setCompleted_date(LocalDateTime.now());
        _TaskDetailsDb.save(task);
        return "redirect:/task/completedTasks";
    }
}
