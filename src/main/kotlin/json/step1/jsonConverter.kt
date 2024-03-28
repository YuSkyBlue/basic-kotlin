package org.example.json.step1

import com.google.gson.Gson
import kotlinx.serialization.json.Json
import org.example.json.step2.User

private fun main(){
    val jsonString = """
            {
                "name" : "Ready Kim",
                "email" : "ready.kim@gmail.com"
            }
        """.trimIndent()
    // Gson은 코틀린의 default value 문법을 무시 Excpected : 20 , Actual = 0
    //  primitive 타입의 필드에 대해서는 0, refernce 타입의 필드에 대해서는 null 값을 기본
    //  gson 컨버터는 코틀린의 null-safety 를 준수하지 않기 때문에 이에 대한 고려를 하지 않으면 Crash를 발생
    // 코틀린에서 Gson, Jackson, Moshi 등을 사용할 때는 각 필드를 nullable 하게 설정
    val user = Gson().fromJson(jsonString, User::class.java)
    println(user)

}