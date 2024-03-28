package org.example.json.step2

import kotlinx.serialization.Serializable

@Serializable
data class User (
    val name: String,
    val email: String,
    val age: Int = 20
)