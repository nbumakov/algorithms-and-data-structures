package com.leatcode.t345

import com.leatcode.util.print

fun main() {
    Solution().reverseVowels("ai").print()
}

class Solution {

    fun reverseVowels(s: String): String {
        var l = 0
        var r = s.lastIndex

        val sb = StringBuilder(s)

        fun StringBuilder.swap(i: Int, j: Int) {
            val temp = this[i]
            this[i] = this[j]
            this[j] = temp
        }

        while (l < r) {
            while (l <= s.lastIndex && !vowels.contains(Character.toLowerCase(s[l]))) l++
            while (r >= 0 && !vowels.contains(Character.toLowerCase(s[r]))) r--
            if (l < r) sb.swap(l++, r--)
        }

        return sb.toString()
    }

    companion object {
        private val vowels = setOf('a', 'e', 'i', 'o', 'u')
    }
}