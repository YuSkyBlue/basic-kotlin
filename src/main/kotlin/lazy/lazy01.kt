package org.example.lazy

//lateinit : 초기화 이후에 계속하여 값이 바뀔 수 있을 때
// by lazy : 초기화 이후에 읽기 전용 값으로 사용할 때
fun main() {
    lateinit var text: String
    val textLength: Int by lazy {
        text.length
    }

    // 대충 중간에 뭔가 했음
    text = "H43RO_Velog"
    println(textLength)
    text = "dddsdf"
}