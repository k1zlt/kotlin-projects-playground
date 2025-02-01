package com.example.simple_to_do_list.data.source.local

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.simple_to_do_list.domain.model.TaskDao
import com.example.simple_to_do_list.domain.model.TaskEntity

@Database(entities = [TaskEntity::class], version = 1)
abstract class AppDatabase: RoomDatabase() {
    abstract fun taskDao(): TaskDao
}