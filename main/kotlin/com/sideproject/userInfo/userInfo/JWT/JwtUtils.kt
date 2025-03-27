package com.sideproject.userInfo.userInfo.JWT

import org.apache.tomcat.util.net.openssl.ciphers.Authentication
import org.springframework.security.core.userdetails.UserDetails
import java.util.*

class JwtUtils {

    // 토큰생성
    fun createToken(username: String): String {
        return ""
    }


    fun validation(token: String): Boolean {
        return false
    }

    // 토큰에서 username 파싱
    fun parseUsername(token: String): String {
        return ""
    }

    // UsernamePasswordAuthenticationToken 데이터 조회
    fun getAuthentication(username: String): Authentication? {
        return null
    }

    // Claims 조회
    private fun getAllClaims(token: String) {

    }
}