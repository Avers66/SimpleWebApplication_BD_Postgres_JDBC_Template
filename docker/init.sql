CREATE SCHEMA IF NOT EXISTS task_schema;

CREATE TABLE IF NOT EXISTS task_schema.task
(
    id BIGINT PRIMARY KEY,
    title VARCHAR(255) NOT NULL,
    description VARCHAR(255) NOT NULL,
    priority INTEGER NOT NULL
)
