package com.leatcode.t2024

import com.leatcode.util.print

fun main() {
    Solution().maxConsecutiveAnswers("TFFT", 1).print()
}

class Solution {

//    fun maxConsecutiveAnswers2(answerKey: String, k: Int): Int {
//        var lT = 0
//        var lF = 0
//        var max = 0
//        answerKey.forEachIndexed { index, c ->
//
//        }
//
//        return max + 1
//    }

    fun maxConsecutiveAnswers(answerKey: String, k: Int): Int =
        maxOf(getMax(answerKey, k, 'T'), getMax(answerKey, k, 'F'))

    private fun getMax(answerKey: String, k: Int, replacingChar: Char): Int {
        var p1 = 0
        var replaces = k
        var max = 0

        answerKey.forEachIndexed { index, c ->
            max = if (c == replacingChar) {
                if (replaces > 0) {
                    replaces--
                    maxOf(max, index - p1)
                } else {
                    while (answerKey[p1] != replacingChar) p1++
                    p1++
                    maxOf(max, index - p1)
                }
            } else {
                maxOf(max, index - p1)
            }
        }

        return max + 1
    }

}