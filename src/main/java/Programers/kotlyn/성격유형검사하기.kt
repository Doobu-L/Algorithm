package Programers.kotlyn

class 성격유형검사하기 {
    fun solution(survey: Array<String>, choices: IntArray): String {
        var surveyType = mutableListOf("RT", "CF", "JM", "AN")

        var scoreBoard = hashMapOf<Char, Int>()

        accumulateScores(choices, survey, scoreBoard)

        return resolveTypeFromScores(surveyType, scoreBoard)
    }

    private fun resolveTypeFromScores(
        surveyType: MutableList<String>,
        scoreBoard: HashMap<Char, Int>
    ): String = surveyType.map { it ->
        var pre = it.get(0)
        var post = it.get(1)

        if ((scoreBoard[pre] ?: 0) >= (scoreBoard[post] ?: 0)) {
            pre
        } else {
            post
        }
    }.joinToString("")

    private fun accumulateScores(
        choices: IntArray,
        survey: Array<String>,
        scoreBoard: HashMap<Char, Int>
    ) {
        choices.forEachIndexed { idx, choice ->
            if (choice == 4) return@forEachIndexed

            var pre = survey.get(idx).get(0)
            var post = survey.get(idx).get(1)

            when {
                choice < 4 -> scoreBoard[pre] = scoreBoard.getOrDefault(pre, 0) + (4 - choice)
                choice > 4 -> scoreBoard[post] = scoreBoard.getOrDefault(post, 0) + (choice - 4)
            }
        }
    }
}