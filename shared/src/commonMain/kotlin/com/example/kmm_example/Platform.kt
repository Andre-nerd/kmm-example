package com.example.kmm_example

interface Platform {
    val name: String
}

expect fun getPlatform(): Platform
