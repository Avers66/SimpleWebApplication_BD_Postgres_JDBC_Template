package com.example.simplewebapplication.listener;

import com.example.simplewebapplication.Task;
import com.example.simplewebapplication.service.TaskService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.boot.context.event.ApplicationStartedEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

import java.awt.desktop.AppReopenedEvent;
import java.util.ArrayList;
import java.util.List;

/**
 * DatabaseTaskCreator
 *
 * @Author Tretyakov Alexandr
 */

@Slf4j
@Component
@RequiredArgsConstructor
public class DatabaseTaskCreator {

    private final TaskService taskService;

//    @EventListener(ApplicationStartedEvent.class)
    public void createTaskData() {
        List<Task> tasks = new ArrayList<>();
        for (int i = 1; i < 11; i++) {

            Task task = new Task();
            task.setId((long) i);
            task.setTitle("title" + i);
            task.setDescription("description" + i);
            task.setPriority(i);
            tasks.add(task);
        }
        taskService.batchInsert(tasks);

    }
}
