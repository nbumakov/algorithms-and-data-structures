package com.leatcode.t3163

import kotlin.math.min

class Solution {
    fun compressedString(word: String): String = buildString {
        var pointer = 0
        while (pointer < word.length) {
            val char = word[pointer]
            var count = 1
            val maxCounter = min(9, word.length - pointer)
            while (count < maxCounter && word[pointer + count] == char) count++
            append("$count$char")
            pointer += count
        }
    }
}