package com.moloy.MyToDoApp.controller;

import com.moloy.MyToDoApp.model.TaskDetails;
import net.bytebuddy.TypeCache;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.Optional;

@Controller
public class HomeController extends BaseController {

    @RequestMapping( value = {"/","home", "home/index", "home/index/{taskid}"})
    public ModelAndView home(@PathVariable("taskid") Optional<Integer> taskid){
        ModelAndView mv = new ModelAndView("home/index");
        mv.addObject("taskTypes", _TaskTypesDb.findAll());
        if(!taskid.isPresent()) {
            mv.addObject("taskList", _TaskDetailsDb.findByIs_completedFalse(false));
        }else{
            mv.addObject("taskList", _TaskDetailsDb.findByIs_completedAAndTask_type(false, taskid));
        }
        mv.addObject("entryModel", new TaskDetails());
        mv.addObject("selectedTask",taskid.orElse(0));

        return mv;
    }
}
