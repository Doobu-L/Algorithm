package Programers.kotlyn

import org.springframework.util.Assert

class 과일장수 {
    fun solution(k: Int, m: Int, score: IntArray): Int {
        score.sortDescending();
        return score.filterIndexed {index, _ -> index % m == m-1 }
            .sum()
            .times(m)
    }


}

fun main() {
    val sol = 과일장수()

    // (k, m, score) -> 기대값
    val tests = listOf(
        Triple(3, 4, intArrayOf(1, 2, 3, 1, 2, 3, 1)) to 8,
        Triple(3, 3, intArrayOf(9, 8, 7, 6, 5)) to 21,
        Triple(4, 2, intArrayOf(1, 1, 1, 1, 1, 1, 1, 1)) to 8,
        Triple(5, 2, intArrayOf(10, 9, 8, 7, 6)) to 28
    )

    for ((input, expected) in tests) {
        val (k, m, score) = input
        val result = sol.solution(k, m, score)
        println("input=$k,$m,${score.joinToString()} => result=$result (expected=$expected) " +
                if (result == expected) "✅" else "❌")
    }
}