package com.leetcode.t2825

import com.leetcode.util.print
import kotlin.math.abs


fun main() {
    println('b' - 'a')
    println(abs('a' - 'z').takeIf { it != 25 } ?: 1)
    println(('z' - 'a' + 26) % 26)

//    Solution().canMakeSubsequence("c", "b").print()
    Solution().canMakeSubsequence("zc", "ad").print()
}

class Solution {
    fun canMakeSubsequence(str1: String, str2: String): Boolean {
        val difs = setOf(0, 1, -25)

        var p1 = 0
        var p2 = 0

        while (p2 < str2.length && p1 < str1.length) {
            if (str2[p2] - str1[p1] in difs) {
                p1++
                p2++
            } else {
                p1++
            }
        }

        return p2 == str2.length
    }
}