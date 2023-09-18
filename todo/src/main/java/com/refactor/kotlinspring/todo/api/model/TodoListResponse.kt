package com.refactor.kotlinspring.todo.api.model

import com.fasterxml.jackson.annotation.JsonIgnore
import com.refactor.kotlinspring.todo.domain.Todo

data class TodoListResponse(
    val items: List<TodoResponse>,
) {

    val size: Int
        @JsonIgnore
        get() = items.size

    fun get(index: Int) = items[index]

    companion object {
        fun of(todoList: List<Todo>) =
            TodoListResponse(todoList.map(TodoResponse::of))
    }

}

