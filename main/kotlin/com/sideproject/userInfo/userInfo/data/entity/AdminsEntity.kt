package com.sideproject.userInfo.userInfo.data.entity

import jakarta.persistence.*

@Entity
@Table(name = "ADMINS")
class AdminsEntity(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    var id: Long,
    @Column(name = "user_name", unique = true)
    var userName: String,
    @Column(name = "nick_name")
    var nickName: String,
    var password: String,
) : BasicEntity() {
}
