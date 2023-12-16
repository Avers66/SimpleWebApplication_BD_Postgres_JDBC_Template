package com.example.simplewebapplication.exception;

/**
 * TaskNoFoundException
 *
 * @Author Tretyakov Alexandr
 */

public class TaskNoFoundException extends RuntimeException {
    public TaskNoFoundException(String message) {
        super(message);
    }
}
