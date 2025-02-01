package com.example.simple_to_do_list.domain.model

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query

@Dao
interface TaskDao {
    @Query("SELECT * FROM task")
    fun getAll(): List<TaskEntity>

    @Query("SELECT * FROM task WHERE uid IN (:taskIds)")
    fun loadAllByIds(taskIds: LongArray): List<TaskEntity>

    @Query("SELECT * FROM task WHERE name LIKE :name")
    fun findByName(name: String): List<TaskEntity>

    @Query("SELECT * FROM task where uid = :taskId LIMIT 1")
    fun findById(taskId: Long): TaskEntity

    @Insert
    fun insertAll(vararg taskEntities: TaskEntity)

    @Delete
    fun delete(taskEntity: TaskEntity): Int
}