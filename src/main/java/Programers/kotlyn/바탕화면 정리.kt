package Programers.kotlyn

class 바탕화면정리 {
    fun solution(wallpaper: Array<String>): IntArray {
        var answer: IntArray = IntArray(4)

        answer[0] = Integer.MAX_VALUE
        answer[1] = Integer.MAX_VALUE
        answer[2] = Integer.MIN_VALUE
        answer[3] = Integer.MIN_VALUE

        wallpaper.forEachIndexed { index, s ->
            if(s.contains("#")){
                answer[0] = minOf(answer[0], index)
                answer[1] = minOf(answer[1], s.indexOfFirst { it.equals('#', true) })
                answer[2] = maxOf(answer[2], index +1)
                answer[3] = maxOf(answer[3], s.indexOfLast { it.equals('#', true) } + 1)
            }
        }

        return answer
    }
}
