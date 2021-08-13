package august.`2021`.mutualevaluation

class Solution {
    fun solution(scores: Array<IntArray>): String {

        if (scores.isEmpty()) {
            return "";
        }

        var answer: String = ""

        for (j in scores[0].indices) {
            val map = mutableMapOf<Int, Int>()
            for (i in scores.indices) {
                map[scores[i][j]] = map.getOrDefault(scores[i][j], 0) + 1
            }

            var min = Integer.MAX_VALUE
            var max = Integer.MIN_VALUE

            for (i in map.keys) {
                val value = i ?: 0
                if (value > max) {
                    max = value
                }
                if (value < min) {
                    min = value
                }
            }

            if (scores[j][j] == max && map[max] == 1) {
                map.remove(max)
            }

            if (scores[j][j] == min && map[min] == 1) {
                map.remove(min)
            }

            var total = 0
            var totalCount = 0
            for (i in map.keys) {
                val count = map[i] ?: 0
                val value = i * count
                totalCount += count
                total += value
            }

            answer += when {
                total >= 90 * totalCount -> {
                    "A"
                }
                total >= 80 * totalCount -> {
                    "B"
                }
                total >= 70 * totalCount -> {
                    "C"
                }
                total >= 50 * totalCount -> {
                    "D"
                }
                else -> {
                    "F"
                }
            }
        }
        return answer
    }
}

fun main() {
    val sol = Solution()
    val array = arrayOf(intArrayOf(100,90,98,88,65),intArrayOf(50,45,99,85,77),intArrayOf(47,88,95,80,67),intArrayOf(61,57,100,80,65),intArrayOf(24,90,94,75,65))
    println(sol.solution(array))
}
