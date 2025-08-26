package Programers.kotlyn

import kotlin.collections.map
import kotlin.collections.minOfOrNull
import kotlin.collections.sumOf
import kotlin.collections.toIntArray
import kotlin.let
import kotlin.text.indexOf
import kotlin.text.sumOf

class 대충만든자판 {
    fun solution(keymap: Array<String>, targets: Array<String>): IntArray {

        return targets.map { target ->
            target.sumOf { ch ->
                keymap.minOfOrNull { key ->
                    val idx = key.indexOf(ch)
                    if(idx > 0) idx + 1 else 101
                } ?: 101
            }.let { total ->
                if(total >= 101) -1 else total
            }
        }.toIntArray()
    }
}