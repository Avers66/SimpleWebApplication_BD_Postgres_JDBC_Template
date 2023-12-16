package com.example.simplewebapplication.service;

import com.example.simplewebapplication.Task;

import java.util.List;
import java.util.Optional;

/**
 * TaskService
 *
 * @Author Tretyakov Alexandr
 */

public interface TaskService {
    List<Task> findAll();
    Task findById(Long id);
    Task save(Task task);
    Task update(Task task);
    void delete(Long id);
    void batchInsert(List<Task> tasks);
}
