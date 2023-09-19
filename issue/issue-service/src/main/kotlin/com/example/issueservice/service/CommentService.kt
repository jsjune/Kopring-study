package com.example.issueservice.service

import com.example.issueservice.domain.Comment
import com.example.issueservice.domain.CommentRepository
import com.example.issueservice.domain.IssueRepository
import com.example.issueservice.exception.NotFoundException
import com.example.issueservice.model.CommentRequest
import com.example.issueservice.model.CommentResponse
import com.example.issueservice.model.toResponse
import org.springframework.data.repository.findByIdOrNull
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional

@Service
class CommentService(
    private val commentRepository: CommentRepository,
    private val issueRepository: IssueRepository,
) {
    @Transactional
    fun create(issueId: Long, userId: Long, username: String, request: CommentRequest): CommentResponse {
        val issue = issueRepository.findByIdOrNull(issueId) ?: throw NotFoundException("이슈가 존재하지 않습니다")

        val comment = Comment(
            issue = issue,
            userId = userId,
            username = username,
            body = request.body,
        )

        issue.comments.add(comment)
        return commentRepository.save(comment).toResponse()
    }

    @Transactional
    fun edit(id: Long, userId: Long, request: CommentRequest): CommentResponse? {
        return commentRepository.findByIdAndUserId(id, userId)?.run {
            body = request.body
            commentRepository.save(this).toResponse()
        }
    }

    @Transactional
    fun delete(issuedId: Long, id: Long, userId: Long) {
        val issue = issueRepository.findByIdOrNull(issuedId) ?: throw NotFoundException("이슈가 존재하지 않습니다")
        commentRepository.findByIdAndUserId(id,userId)?.let {
            issue.comments.remove(it)
        }
    }
}
