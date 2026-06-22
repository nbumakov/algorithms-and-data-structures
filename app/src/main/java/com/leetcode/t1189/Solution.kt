package com.leetcode.t1189

class Solution {
    fun maxNumberOfBalloons(text: String): Int {
        val ref = countChars("balloon")
        val count = countChars(text)
        return (0 until 26)
            .filter { ref[it] > 0 }
            .minOf { count[it] / ref[it] }
    }

    private fun countChars(text: String): IntArray {
        val result = IntArray(26)
        for (c in text) {
            result[c - 'a']++
        }
        return result
    }
}