package com.leetcode.t2785

import com.leetcode.util.print

fun main() {
    Solution().sortVowels("lEetcOde").print()
}

class Solution {

    fun sortVowels(s: String): String = buildString {
        val vowelsIterator = s.filter { it in Vowels }.toList().sorted().iterator()
        for (c in s) {
            if (c in Vowels) append(vowelsIterator.next()) else append(c)
        }
    }

    companion object {
        private val Vowels = setOf('a', 'e', 'i', 'o', 'u', 'A', 'E', 'I', 'O', 'U')
    }
}