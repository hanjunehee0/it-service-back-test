package com.sideproject.userInfo.userInfo.controller

import com.sideproject.userInfo.userInfo.data.entity.UsersEntity
import com.sideproject.userInfo.userInfo.service.UserService
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*


@RestController
class AdminController {
    @RestController
    @RequestMapping("/admins")
    class UserController(
            private val userService: UserService
    ) {
        @GetMapping
        fun getUsersList(): ResponseEntity<List<UsersEntity>> {
            return ResponseEntity.ok(userService.getUserList())
        }

        @PostMapping
        fun createUser(): ResponseEntity<UsersEntity> {
            return ResponseEntity.ok(userService.createUser())
        }

        @PutMapping
        fun editUser(): ResponseEntity<UsersEntity> {
            return ResponseEntity.ok(userService.editUser())
        }

        @DeleteMapping
        fun deleteUser(): ResponseEntity<UsersEntity> {
            return ResponseEntity.ok(userService.deleteUser())
        }
    }
}