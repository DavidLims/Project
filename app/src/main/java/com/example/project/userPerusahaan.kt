package com.example.project

class userPerusahaan (
    val userId: String,
    val username: String,
    val email: String,
    val password: String,

    ) {
        constructor() : this("", "", "", "")
}