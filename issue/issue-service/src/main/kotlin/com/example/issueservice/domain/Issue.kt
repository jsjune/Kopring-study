package com.example.issueservice.domain

import com.example.issueservice.domain.enum.IssuePriority
import com.example.issueservice.domain.enum.IssueStatus
import com.example.issueservice.domain.enum.IssueType
import jakarta.persistence.*

@Entity
@Table
class Issue(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long? = null,

    var userId: Long,

    @OneToMany(fetch = FetchType.EAGER)
    val comments: MutableList<Comment> = mutableListOf(),

    var summary: String,
    var description: String,
    @Enumerated(EnumType.STRING)
    var type: IssueType,
    @Enumerated(EnumType.STRING)
    var priority: IssuePriority,
    @Enumerated(EnumType.STRING)
    var status: IssueStatus,
) : BaseEntity() {
}
