package com.example.issueservice.web

import com.example.issueservice.config.AuthUser
import com.example.issueservice.model.CommentRequest
import com.example.issueservice.service.CommentService
import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/api/v1/issues/{issuedId}/comments")
class CommentController(
    private val commentService: CommentService
) {
    @PostMapping
    fun create(
        authUser: AuthUser,
        @PathVariable issuedId: Long,
        @RequestBody request: CommentRequest
    ) = commentService.create(issuedId, authUser.userId, authUser.username, request)

    @PutMapping("/{id}")
    fun edit(
        authUser: AuthUser,
        @PathVariable id: Long,
        @RequestBody request: CommentRequest
    ) = commentService.edit(id, authUser.userId, request)

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    fun delete(
        authUser: AuthUser,
        @PathVariable issuedId: Long,
        @PathVariable id: Long,
    ) {
        commentService.delete(issuedId, id, authUser.userId)
    }
}
