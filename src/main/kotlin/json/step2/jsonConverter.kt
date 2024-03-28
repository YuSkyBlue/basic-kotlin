package org.example.json.step2

import kotlinx.serialization.json.Json

private fun main(){
    val jsonString = """
            {
                "name" : "Ready Kim",
                "email" : "ready.kim@gmail.com"
            }
        """.trimIndent()
    // Gson은 코틀린의 default value 문법을 무시 Excpected : 20 , Actual = 0

//    val user = Gson().fromJson(jsonString, User::class.java)
    val decodeUser = Json.decodeFromString<User>(jsonString)
    println(decodeUser)

}