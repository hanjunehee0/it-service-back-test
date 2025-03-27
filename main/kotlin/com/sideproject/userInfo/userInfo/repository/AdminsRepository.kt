package com.sideproject.userInfo.userInfo.repository

import com.sideproject.userInfo.userInfo.data.entity.AdminsEntity
import org.springframework.data.jpa.repository.JpaRepository

interface AdminsRepository: JpaRepository<AdminsEntity, Long> {
}