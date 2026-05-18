package com.leatcode.t2491

fun main() {
    Solution().dividePlayers(intArrayOf(2, 2, 2, 2))
        .let(::println)
}

class Solution {
    fun dividePlayers(skill: IntArray): Long {
        val averageTeamSkill = (2 * skill.sum()) / skill.size
        val freq = IntArray(1001).apply { skill.forEach { this[it]++ } }
        var result = 0L

        for (s in skill) {
            if (freq[s] == 0) continue
            val complement = averageTeamSkill - s
            if (freq.getOrElse(complement) { 0 } > 0) {
                result += s * complement
                freq[s]--
                freq[complement]--
                if (freq[complement] < 0) return -1L
            } else {
                return -1L
            }
        }

        return result
    }
}