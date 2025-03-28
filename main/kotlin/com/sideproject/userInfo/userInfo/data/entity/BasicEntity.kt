package com.sideproject.userInfo.userInfo.data.entity

import jakarta.persistence.Column
import jakarta.persistence.EntityListeners
import jakarta.persistence.MappedSuperclass
import org.springframework.data.annotation.CreatedDate
import org.springframework.data.annotation.LastModifiedDate
import org.springframework.data.jpa.domain.support.AuditingEntityListener
import java.time.LocalDateTime

@MappedSuperclass
@EntityListeners(AuditingEntityListener::class)
abstract class BasicEntity {
    @CreatedDate
    var createdAt: LocalDateTime = LocalDateTime.now()
    @LastModifiedDate
    var updatedAt: LocalDateTime = LocalDateTime.now()
    var deletedAt: LocalDateTime = LocalDateTime.now()

}