package com.cabovianco.t0d0.data.local.entity

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.cabovianco.t0d0.data.repository.model.Task

@Entity(tableName = "task_table")
data class TaskEntity(
    @PrimaryKey(autoGenerate = true)
    val id: Int = 0,
    val title: String,
    val done: Boolean = false
)

fun TaskEntity.toItem() = Task(id = id, title = title, done = done)
