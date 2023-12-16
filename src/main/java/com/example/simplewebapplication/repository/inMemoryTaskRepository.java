package com.example.simplewebapplication.repository;

import com.example.simplewebapplication.Task;
import lombok.extern.java.Log;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

/**
 * inMemoryTaskRepository
 *
 * @Author Tretyakov Alexandr
 */


@Slf4j
@Repository
public class inMemoryTaskRepository implements TaskRepository{

    private final List<Task> tasks = new ArrayList<>();

    public List<Task> findAll() {
        log.info("Запрос из БД всех значений");
        return tasks;
    }

    public Optional<Task> findById(Long id) {
        log.info("Поиск в БД значения по ID = " + id);
        return tasks.stream().filter(t -> t.getId().equals(id)).findFirst();

    }

    public Task save(Task task){
        log.info("Добавление в БД нового значения. Task = " + task);
        task.setId(System.currentTimeMillis());
        tasks.add(task);
        return task;
    }

    public Task update(Task task){
        log.info("Редактирование задачи в БД. Task = " + task);
        Task editTask = findById(task.getId()).orElse(null);
        editTask.setTitle(task.getTitle());
        editTask.setDescription(task.getDescription());
        editTask.setPriority(task.getPriority());
        return editTask;
    }

    public void delete(Long id) {
        log.info("Удаление значения мз БД. Id = " + id);
        findById(id).ifPresent(tasks::remove);
    }

    @Override
    public void batchInsert(List<Task> tasks) {
        this.tasks.addAll(tasks);
    }
}
