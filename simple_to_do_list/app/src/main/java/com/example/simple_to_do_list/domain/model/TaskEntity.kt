package com.example.simple_to_do_list.domain.model

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "task")
data class TaskEntity(
    @PrimaryKey(autoGenerate = true) val uid: Long = 0,
    var name: String,
    var description: String,
    var isDone: Boolean
)
