package com.chimu.tasklist;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Controller
public class HomeRestController {
    private  final TaskListDao dao;

    @Autowired
    HomeRestController(TaskListDao dao){
        this.dao=dao;
    }
    record TaskItem(String id, String task, String deadline, boolean done) {
    }


    @RequestMapping( "/hello")
    public String hello(Model model) {
        model.addAttribute("time",LocalDateTime.now());
        return "hello";
    }

    @RequestMapping("list")
    String home(Model model){
        List<TaskItem> taskItems=this.dao.findAll();
        model.addAttribute("taskList",taskItems);
        return "home";
    }


    @RequestMapping("/add")
    String add(@RequestParam("task") String task, @RequestParam("deadline") String deadline) {
        String id = UUID.randomUUID().toString().substring(0, 8);
        TaskItem item = new TaskItem(id, task, deadline, false);
        this.dao.add(item);
        return "redirect:/list";
    }

    @RequestMapping("/update")
    String update(@RequestParam("id") String id,@RequestParam("task") String task, @RequestParam("deadline") String deadline, @RequestParam("done") boolean done){
     TaskItem taskItem= new TaskItem(id,task,deadline,done);
     dao.update(taskItem);
     return "redirect:/list";
    }

    @RequestMapping("/delete")
    String delete(@RequestParam("id") String id){
        this.dao.delete(id);
        return "redirect:/list";
    }


}
