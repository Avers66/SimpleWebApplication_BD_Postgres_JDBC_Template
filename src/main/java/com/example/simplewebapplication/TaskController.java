package com.example.simplewebapplication;

import com.example.simplewebapplication.service.TaskService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

/**
 * TaskController
 *
 * @Author Tretyakov Alexandr
 */

@Slf4j
@Controller
@RequiredArgsConstructor
public class TaskController {

    private final TaskService taskService;



    @GetMapping("/")
    public String index(Model model) {
        model.addAttribute("tasks", taskService.findAll());
        return "index";
    }

    @GetMapping("/task/create")
    public String showCreateForm(Model model) {
        model.addAttribute("task", new Task());
        return "create";

    }

    @PostMapping("/task/create")
    public String createTask(@ModelAttribute Task task) {
        taskService.save(task);
        return "redirect:/";
    }

    @GetMapping("/task/edit/{id}")
    public String showEditForm(@PathVariable Long id, Model model) {
        Task task = taskService.findById(id);
        if (task != null) {
            model.addAttribute("task", task);
            return "edit";
        }
        return "redirect:/";
    }

    @PostMapping("/task/edit")
    public String editTask(@ModelAttribute Task task) {
        taskService.update(task);
        return "redirect:/";

    }

    @GetMapping("/task/delete/{id}")
    public String deleteTask(@PathVariable Long id) {
        taskService.delete(id);
        return "redirect:/";
    }



}
