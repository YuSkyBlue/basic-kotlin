package org.example.json

private fun main(){
    val str1 =
        """
    AND os_type
    AND channel
    AND LOWER(name)
    AND age
""".trimIndent()
    //모든 입력 라인의 공통 최소 들여쓰기를 감지하고 모든 라인에서 그만큼
    // 비어있는 첫번째와 마지막 라인 제거\
    println(str1)

    println("-----------------------------")


    val str2 =
        """         AND os_type
            AND channel
            AND LOWER(name)
            AND age
        """.trim()
    //문자열 양 끝 공백을 제거한다
    println(str2)
    println("-----------------------------")


    val str3 =
        """
        |   XYZ
        foo
        bar
    """.trimMargin()
//    여백이 기준이 되는 문자열을 지정할 수 있다
//    default는 | 이고, 괄호 안에 값을 넣어주면 그걸로도 사용할 수 있다
//    지정한 문자까지 여백으로 두고 거기까지 지운다
    println(str3)
}
