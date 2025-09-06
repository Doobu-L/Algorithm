package Programers.kotlyn

import java.time.LocalDate
import java.time.format.DateTimeFormatter

class 개인정보수집유효기간 {

    fun solution(today: String, terms: Array<String>, privacies: Array<String>): IntArray {
        var answer: IntArray = intArrayOf()
        val termsMap: Map<String, Int> =
            terms.associateBy({ it.split(" ")[0] }, { it.split(" ")[1].toInt() })


        privacies.forEachIndexed { idx, it ->
            val date = it.split(" ")[0]
            val period: Int = termsMap.get(it.split(" ")[1])!!
            val expiredDate = getExpireDate(date, period)

            if(isExpired(today, expiredDate))
                answer.plus(idx)
        }

        return answer
    }

    fun getExpireDate(date: String, period: Int) : String {
        val year = date.split(".")[0].toInt()
        val month = date.split(".")[1].toInt()
        val day = date.split(".")[2].toInt()

        var expireYear = year + (month+period)/12
        var expireMonth = (month + period) % 12
        var expireDays = day - 1;

        if(expireDays == 0){
            if(expireMonth == 1) {
                expireMonth = 12
                expireYear -= 1
            } else if(expireMonth == 0) {
                expireMonth = 12
            } else {
                expireMonth -= 1
            }
            expireDays = 28
        }

        return LocalDate.of(expireYear,expireMonth,expireDays)
            .format(DateTimeFormatter.ofPattern("yyyy.MM.dd")).toString()
    }

    fun isExpired(today: String, expiredDate: String) : Boolean {
        val pToday = LocalDate.parse(today, DateTimeFormatter.ofPattern("yyyy.MM.dd"))
        val pExpiredDate = LocalDate.parse(expiredDate, DateTimeFormatter.ofPattern("yyyy.MM.dd"))
        return pToday.isBefore(pExpiredDate)
    }
}

fun main(){
    val sol = 개인정보수집유효기간()
    sol.solution("2022.05.19", arrayOf("A 6", "B 12", "C 3"), arrayOf("2021.05.02 A", "2021.07.01 B", "2022.02.19 C", "2022.02.20 C"))
}