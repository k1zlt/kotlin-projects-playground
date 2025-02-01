package com.example.simple_to_do_list.data.repository

import com.example.simple_to_do_list.domain.model.TaskDao
import com.example.simple_to_do_list.domain.model.TaskEntity


class TaskRepository (
    private val taskDao: TaskDao
) {
    suspend fun getTask(
        taskId: Long? = null,
        taskName: String? = null
    ): TaskEntity? {
        return when {
            taskId != null -> taskDao.findById(taskId)
            taskName != null -> taskDao.findByName(taskName).firstOrNull()
                ?: throw Exception("Task with '$taskName' not found!")
            else -> throw Exception("Either task name or id should be provided.")
        }
    }

    suspend fun getAll(): List<TaskEntity> {
        return taskDao.getAll()
    }

    suspend fun loadAllByIds(taskIds: LongArray): List<TaskEntity> {
        return taskDao.loadAllByIds(taskIds)
    }

    suspend fun addTask(vararg taskEntities: TaskEntity) {
        if (taskEntities.isNotEmpty()) taskDao.insertAll(*taskEntities)
        throw IllegalArgumentException("At least one task must be provided for insertion.")
    }

    suspend fun deleteTask(taskEntity: TaskEntity): Boolean {
        return taskDao.delete(taskEntity) > 0
    }
}