package august.`2021`.idrecommend

class Solution {
    fun solution(new_id: String): String {
        var answer: String = new_id.toLowerCase()
            .replace("[^a-z0-9\\-\\_\\.]".toRegex(), "")
            .replace("[\\.]+".toRegex(), ".")
            .replace("[\\.]\$".toRegex(), "")
            .replace("^[\\.]".toRegex(), "")

        if (answer.isEmpty()) {
            answer = "a"
        }

        if (answer.length >= 16) {
            answer = answer.substring(0, 14).replace("[\\.]\$", "")
        }

        if (answer.length <= 2) {
            for (i in answer.length..2) {
                answer += answer.takeLast(1)
            }
        }

        return answer
    }
}

fun main() {
    println(Solution().solution("abc"))
}