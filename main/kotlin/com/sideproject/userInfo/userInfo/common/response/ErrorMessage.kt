package com.sideproject.userInfo.userInfo.common.response

class ErrorMessage {
    companion object {
        // 회원가입 & 계정 관련 에러
        val EMAIL_ALREADY_EXISTS = "Email already exists"
        val INVALID_EMAIL_FORMAT = "Invalid email format"
        val MISSING_REQUIRED_FIELDS = "Missing required fields"
        val FAILED_TO_CREATE_USER = "Failed to create user"
        val SERVER_ERROR_CREATE_USER = "Failed to create user due to server error"

        // 로그인 관련 에러
        val INVALID_EMAIL_OR_PASSWORD = "Invalid email or password"
        val EMAIL_NOT_FOUND = "Email not found"
        val INCORRECT_PASSWORD = "Incorrect password"
        val TOKEN_EXPIRED = "Token has expired"
        val LOGIN_SERVER_ERROR = "Login failed due to server error"
        val NO_TOKEN_PROVIDED = "No token provided"
    }
}