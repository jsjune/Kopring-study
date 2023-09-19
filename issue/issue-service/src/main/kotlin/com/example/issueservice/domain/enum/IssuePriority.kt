package com.example.issueservice.domain.enum

enum class IssuePriority {
    LOW, MEDIUM, HIGH;

    companion object {
        operator fun invoke(priority: String) = valueOf(priority.uppercase())
    }
}
