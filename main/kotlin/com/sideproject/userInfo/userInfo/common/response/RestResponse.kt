package com.sideproject.userInfo.userInfo.common.response

class RestResponse<T>(
    val resultCode: String,
    val resultMessage: String,
    val resultData: T
) {
    companion object {
        fun <T> success(data: T): RestResponse<T> {
            return RestResponse(
                resultCode = "A201",
                resultMessage = "Success",
                resultData = data
            )
        }

        fun <T> badRequest(message: String, data: T): RestResponse<T> {
            return RestResponse(
                resultCode = "A400",
                resultMessage = "Bad Request",
                resultData = data
            )
        }

        fun <T> unauthorized(message: String, data: T): RestResponse<T> {
            return RestResponse(
                resultCode = "A401",
                resultMessage = "Unauthorized",
                resultData = data
            )
        }

        fun <T> internalServerError(message: String, data: T): RestResponse<T> {
            return RestResponse(
                resultCode = "A500",
                resultMessage = "Internal Server Error",
                resultData = data
            )
        }
    }
}