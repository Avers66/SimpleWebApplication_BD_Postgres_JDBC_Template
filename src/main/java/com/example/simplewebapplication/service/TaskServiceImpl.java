package com.example.simplewebapplication.service;

import com.example.simplewebapplication.Task;
import com.example.simplewebapplication.repository.TaskRepository;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * TaskServiceImpl
 *
 * @Author Tretyakov Alexandr
 */


@Slf4j
@Service
@RequiredArgsConstructor
public class TaskServiceImpl implements TaskService{

    private final TaskRepository taskRepository;

    @Override
    public List<Task> findAll() {
        log.info("TaskServiceImpl.findAll()");
        return taskRepository.findAll();
    }

    @Override
    public Task findById(Long id) {
        log.info("TaskServiceImpl.findById(" + id + ")");
        return taskRepository.findById(id).orElse(null);
    }

    @Override
    public Task save(Task task) {
        log.info("TaskServiceImpl.save(" + task + ")");
        return taskRepository.save(task);
    }

    @Override
    public Task update(Task task) {
        log.info("TaskServiceImpl.update(" + task + ")");
        return taskRepository.update(task);
    }

    @Override
    public void delete(Long id) {
        log.info("TaskServiceImpl.delete(" + id + ")");
        taskRepository.delete(id);
    }

    @Override
    public void batchInsert(List<Task> tasks) {
        taskRepository.batchInsert(tasks);
    }
}
