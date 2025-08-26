package Programers.kotlyn

class 숫자짝궁 {
    //solution1 - 정합성 성공, 효율성 실패
    fun solution1(X: String, Y: String): String {
        var Y1: StringBuilder = StringBuilder(Y)

        val result = X.map { it: Char ->
            var pos = Y1.indexOf(it)

            if (Y1.contains(it)) {
                Y1.deleteCharAt(pos)
                it.toString()
            } else {
                ""
            }
        }.sortedDescending().joinToString("")

        return when{
            result.startsWith("0") -> "0"
            result.isEmpty() -> "-1"
            else -> result
        }
    }
}