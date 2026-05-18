package com.leetcode.t1271

import com.leetcode.util.print


fun main() {
    Solution().toHexspeak("747823223228").print()
}

class Solution {

    fun toHexspeak(num: String): String = num
        .toLong()
        .toString(16)
        .uppercase()
        .replace("0", "O")
        .replace("1", "I")
        .takeIf { it.all { letter -> letter in ValidLetters } } ?: "ERROR"

    companion object {
        private val ValidLetters = setOf('A', 'B', 'C', 'D', 'E', 'F', 'I', 'O')
    }
}