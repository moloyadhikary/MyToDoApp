package com.moloy.MyToDoApp.controller;

import com.moloy.MyToDoApp.model.SubTaskDetails;
import com.moloy.MyToDoApp.model.TaskDetails;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;

@Controller
@RequestMapping("/subTask/")
public class SubTaskController extends BaseController {

    @PostMapping("addNewSubTask")
    public String addNewTask(HttpServletRequest request){
        SubTaskDetails model = new SubTaskDetails();
        model.setParentTask(_TaskDetailsDb.findById(Integer.parseInt(request.getParameter("mainTaskId"))).orElse(new TaskDetails()));
        model.setSt_text(request.getParameter("subTaskText"));
        model.setSt_status("Raised");
        _SubTaskDetailsDb.save(model);
        return "redirect:/home";
    }


    @GetMapping("editSubTask/{id}")
    public ModelAndView editSubTask(@PathVariable("id") String id){
        SubTaskDetails model = _SubTaskDetailsDb.findById(Integer.parseInt(id)).orElse(new SubTaskDetails());
        ModelAndView mv = new ModelAndView("subtask/editSubTask");
        mv.addObject("model",model);
        return mv;
    }

    @PostMapping("editSubTaskPost")
    public  String editSubTaskPost(SubTaskDetails model){
        SubTaskDetails extModel = _SubTaskDetailsDb.findById(model.getId()).orElse(new SubTaskDetails());
        extModel.setSt_status(model.getSt_status());
        extModel.setSt_text(model.getSt_text());
        extModel.setSt_description(model.getSt_description());
        _SubTaskDetailsDb.save(extModel);
        return "redirect:/home";
    }

    @GetMapping("deleteSubTask/{id}")
    public String deleteSubTask(@PathVariable("id") String id) {
        SubTaskDetails model = _SubTaskDetailsDb.findById(Integer.parseInt(id)).orElse(new SubTaskDetails());
        _SubTaskDetailsDb.delete(model);
        return "redirect:/home";
    }
}
