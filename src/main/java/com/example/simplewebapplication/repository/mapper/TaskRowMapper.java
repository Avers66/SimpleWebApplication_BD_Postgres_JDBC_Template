package com.example.simplewebapplication.repository.mapper;

import com.example.simplewebapplication.Task;
import org.springframework.jdbc.core.RowMapper;

import javax.swing.tree.TreePath;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * TaskRowMapper
 *
 * @Author Tretyakov Alexandr
 */

public class TaskRowMapper implements RowMapper<Task> {

    @Override
    public Task mapRow(ResultSet rs, int rowNum) throws SQLException {
        Task task = new Task();
        task.setId(rs.getLong("id"));
        task.setTitle(rs.getString("title"));
        task.setDescription(rs.getString("description"));
        task.setPriority(rs.getInt("priority"));
        return task;
    }
}


