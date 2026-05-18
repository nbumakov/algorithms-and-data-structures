package com.leetcode.t93

import com.leetcode.util.print

fun main() {
    Solution().restoreIpAddresses("25525511135").print()
}

class Solution {
    fun restoreIpAddresses(s: String): List<String> {
        val result = mutableListOf<String>()
        val curr = mutableListOf<String>()
        fun backtrack(i: Int = 0, n: Int = 1) {
            if (i > s.lastIndex) return
            if (n == 4) {
                if (s.substring(i).isValid()) {
                    curr.add(s.substring(i))
                    result.add(curr.joinToString("."))
                    curr.removeLast()
                }
                return
            }

            var j = 0
            while (i + j < s.lastIndex && s.substring(i..i + j).isValid()) {
                curr.add(s.substring(i..i + j))
                backtrack(i + j + 1, n + 1)
                curr.removeLast()
                j++
            }
        }

        backtrack()

        return result
    }

    private fun String.isValid(): Boolean {
        if (this.startsWith("0") && length > 1) return false
        return toIntOrNull() in 0..255
    }
}