package com.example.simple_to_do_list.presentation.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.simple_to_do_list.data.repository.TaskRepository
import com.example.simple_to_do_list.domain.model.TaskEntity
import kotlinx.coroutines.launch

class TaskViewModel(
    private val repository: TaskRepository
): ViewModel() {
    private val _taskEntity = MutableLiveData<TaskEntity>()
    val taskEntity: LiveData<TaskEntity> = _taskEntity

    private val _tasks = MutableLiveData<List<TaskEntity>>()
    val tasks: LiveData<List<TaskEntity>> = _tasks

    private val _loading = MutableLiveData<Boolean>()
    val loading: LiveData<Boolean> = _loading

    private val _error = MutableLiveData<String>()
    val error: LiveData<String> = _error

    fun fetchTask(taskId: Long) {
        _loading.value = true
        viewModelScope.launch {
            try {
                _taskEntity.value = repository.getTask(taskId = taskId)
            } catch (e: Exception) {
                _error.value = "Failed to load the task with id $taskId"
            } finally {
                _loading.value = false
            }
        }
    }

    fun fetchAllTasks() {
        _loading.value = true
        viewModelScope.launch {
            try {
                _tasks.value = repository.getAll()
            } catch (e: Exception) {
                _error.value = "Failed to fetch tasks!"
            } finally {
                _loading.value = false
            }
        }
    }
}