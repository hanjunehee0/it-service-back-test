package com.example.test_kotlin.auth

import com.sideproject.userInfo.userInfo.common.response.RestResponse
import com.sideproject.userInfo.userInfo.data.entity.UsersEntity
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/auth")
class AuthController(
) {
    @PostMapping("/signup")
    fun signUp(): RestResponse<UsersEntity> {
        // todo example
        val testResponse = RestResponse.internalServerError(
            message = "Test successfully signed up",
            data = mapOf("data" to {
                "username" to { "lim" }
            }),
        )
        return RestResponse.success(
            UsersEntity(1, "test",
                "test", "gender",
                true, "back", "description"
            )
        )
    }


    @PostMapping("/login")
    fun login() {

    }

    @PostMapping("/logout")
    fun logout() {

    }
}