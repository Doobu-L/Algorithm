package Programers.kotlynimport java.util.Stack

class 뒤에있는큰수kt {
    fun solution(numbers: IntArray): IntArray {
        var answer: IntArray = IntArray(numbers.size) {-1}
        var st: Stack<Int> = Stack<Int>()

        for(i in numbers.lastIndex downTo 0) {
            while(st.isNotEmpty() && numbers[st.peek()] <= numbers[i]) {
                st.pop()
            }

            if(st.isNotEmpty())
                answer[i] = numbers[st.peek()]

            st.push(i)
        }

        return answer
    }
}