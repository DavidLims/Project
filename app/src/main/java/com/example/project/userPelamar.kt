package com.example.project

class userPelamar (
    val userId: String,
    val email: String,
    val username: String,
    val password: String,
    val noHp: String
    ) {
        constructor() : this("", "", "", "", "")
}