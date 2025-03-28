package com.sideproject.userInfo.userInfo.service

import com.sideproject.userInfo.userInfo.data.entity.UsersEntity
import com.sideproject.userInfo.userInfo.repository.UsersRepository
import org.springframework.transaction.annotation.Transactional
import org.springframework.security.core.userdetails.UserDetails
import org.springframework.security.core.userdetails.UserDetailsService
import org.springframework.security.core.userdetails.UsernameNotFoundException
import org.springframework.stereotype.Service


@Service
@Transactional(readOnly = true)
class CustomUserDetailsService(
        private val userRepository: UsersRepository
) : UserDetailsService {

    override fun loadUserByUsername(id: String): UserDetails? {
        val user: UsersEntity = userRepository.findById(id.toLong())
                .orElseThrow { UsernameNotFoundException("존재하지않는 유져") }
        return null;
    }
}