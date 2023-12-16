package com.example.simplewebapplication.repository;

import com.example.simplewebapplication.Task;

import java.time.Instant;
import java.util.List;
import java.util.Optional;

/**
 * TskRepository
 *
 * @Author Tretyakov Alexandr
 */



public interface TaskRepository {

    List<Task> findAll();
    Optional<Task> findById(Long id);
    Task save(Task task);
    Task update(Task task);
    void delete(Long id);

    void batchInsert(List<Task> tasks);

}
