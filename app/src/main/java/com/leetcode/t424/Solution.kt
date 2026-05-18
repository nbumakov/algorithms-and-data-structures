package com.leetcode.t424

import com.leetcode.util.print

fun main() {
//    Solution().characterReplacement("AABABBA", 1).print()
//    Solution().characterReplacement("BAAAB", 2).print()
    Solution().characterReplacement("ABCCCCC", 2).print()
}

class Solution {
    fun characterReplacement(s: String, k: Int): Int {
        val freq = IntArray(26)
        var p1 = 0
        var p2 = 0
        var maxLength = 0
        while (p2 < s.length) {
            val max = freq.max()
            val replaces = k - (p2 - p1 - max)
            when {
                freq[s[p2] - 'A'] == max -> {
                    freq[s[p2] - 'A']++
                    p2++
                }
                replaces > 0 -> {
                    freq[s[p2] - 'A']++
                    p2++
                }
                else -> {
                    freq[s[p1] - 'A']--
                    p1++
                }
            }
            maxLength = maxOf(maxLength, p2 - p1)
        }
        return maxLength
    }
}