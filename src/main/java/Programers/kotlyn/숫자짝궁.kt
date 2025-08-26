package Programers.kotlyn

class 숫자짝궁 {
    fun solution(X: String, Y: String): String {
        var sb = StringBuilder();

        for(num in 9 downTo 0){
            var cnt = minOf( X.count { it == ('0'+num) }, Y.count { it == ('0'+num) })

            repeat(cnt){
                sb.append(num)
            }
        }

        return when {
            sb.isEmpty() -> "-1"
            sb.startsWith("0") -> "0"
            else -> sb.toString()
        }
    }
}