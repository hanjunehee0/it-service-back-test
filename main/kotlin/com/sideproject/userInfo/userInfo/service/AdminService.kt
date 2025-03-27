package com.sideproject.userInfo.userInfo.service

import com.sideproject.userInfo.userInfo.data.entity.AdminsEntity
import com.sideproject.userInfo.userInfo.data.entity.UsersEntity
import com.sideproject.userInfo.userInfo.repository.AdminsRepository
import org.springframework.transaction.annotation.Transactional
import org.springframework.stereotype.Service

@Service
class AdminService(
        private val adminsRepository: AdminsRepository
) {
    fun getUserList(): List<AdminsEntity> {
        return adminsRepository.findAll();
    }

    @Transactional
    fun createUser(): UsersEntity {
        return UsersEntity(1, "test",
                "test", "gender",
                true, "back", "description"
        )
    }
    @Transactional
    fun editUser(): UsersEntity {
        return UsersEntity(1, "test",
                "test", "gender",
                true, "back", "description"
        )
    }
    @Transactional
    fun deleteUser(): UsersEntity {
        return UsersEntity(1, "test",
                "test", "gender",
                true, "back", "description"
        )
    }
}