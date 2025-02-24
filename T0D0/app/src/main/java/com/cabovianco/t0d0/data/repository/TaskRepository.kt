package com.cabovianco.t0d0.data.repository

import com.cabovianco.t0d0.data.local.dao.TaskDao
import com.cabovianco.t0d0.data.local.entity.TaskEntity
import com.cabovianco.t0d0.data.local.entity.toItem
import com.cabovianco.t0d0.data.repository.model.Task
import com.cabovianco.t0d0.data.repository.model.toEntity
import javax.inject.Inject

class TaskRepository @Inject constructor(
    private val taskDao: TaskDao
) {

    suspend fun insertTask(task: Task) {
        taskDao.insertTask(task.toEntity())
    }

    suspend fun getToDoTasks(): List<Task> {
        return taskDao.getNotDoneTasks().map { it.toItem() }
    }

    suspend fun getDoneTasks(): List<Task> {
        return taskDao.getDoneTasks().map { it.toItem() }
    }

    suspend fun deleteTask(task: TaskEntity) {
        taskDao.deleteTask(task)
    }

}
