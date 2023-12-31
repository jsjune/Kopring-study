package com.example.issueservice.domain

import jakarta.persistence.*

@Entity
@Table
class Comment(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long? = null,

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "issue_id")
    val issue: Issue,

    val userId: Long,
    val username: String,
    var body: String,

    ) : BaseEntity()
