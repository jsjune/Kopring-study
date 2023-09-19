package com.example.issueservice.domain.enum

enum class IssueStatus {
    TODO, IN_PROGRESS, RESOLVED;

    companion object {
        operator fun invoke(status: String) = valueOf(status.uppercase())
    }
}
