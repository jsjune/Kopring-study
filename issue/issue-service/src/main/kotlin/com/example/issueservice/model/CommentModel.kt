package com.example.issueservice.model

import com.example.issueservice.domain.Comment

data class CommentRequest(
    val body: String,
)

data class CommentResponse(
    val id: Long,
    val issuedId: Long,
    val userId: Long,
    val body: String,
    val username: String? = null,
)

fun Comment.toResponse() = CommentResponse(
    id = id!!,
    issuedId = issue.id!!,
    userId = userId,
    body = body,
    username = username,
)
