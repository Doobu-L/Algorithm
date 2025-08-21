package Programers.kotlyn

import kotlin.collections.count
import kotlin.text.contains
import kotlin.text.isEmpty
import kotlin.text.replace

class 옹알이 {
    private val AVAIL_BABBLING = listOf("aya", "ye", "woo", "ma")

    fun solution(babbling: Array<String>): Int {
        return babbling.count { canBabbling(it) }
    }

    private fun canBabbling(s0: String): Boolean {
        var s = s0

        for (b in AVAIL_BABBLING) {
            if (s.contains(b + b)) return false
        }

        for (b in AVAIL_BABBLING) {
            s = s.replace(b, "-")
        }

        return s.replace("-", "").isEmpty()
    }
}