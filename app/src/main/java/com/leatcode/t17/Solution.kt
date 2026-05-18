package com.leatcode.t17

import java.lang.StringBuilder
import java.util.Stack

fun main() {
    Solution().letterCombinations("234567").forEach {
        println(it)
    }
}

class Solution {
    private val map = mapOf(
        '2' to "abc",
        '3' to "def",
        '4' to "ghi",
        '5' to "jkl",
        '6' to "mno",
        '7' to "pqrs",
        '8' to "tuv",
        '9' to "wxyz"
    )

    fun letterCombinations(digits: String): List<String> {
        if (digits.isEmpty()) return emptyList()

        val result = mutableListOf<String>()
        fun backtrack(curr: StringBuilder, index: Int) {
            if (index > digits.lastIndex) {
                result.add(curr.toString())
                return
            }

            val letters = map[digits[index]]!!
            for (c in letters) {
                curr.append(c)
                backtrack(curr, index + 1)
                curr.deleteCharAt(curr.lastIndex)
            }
        }
        backtrack(StringBuilder(), 0)
        return result
    }

}