package com.leetcode.t125

import com.leetcode.util.print

fun main() {
    Solution().isPalindrome("A man, a plan, a canal: Panama").print()
}

class Solution {

    fun isPalindrome(s: String): Boolean {
        val s = s.lowercase()
        var lp = 0
        var rp = s.lastIndex
        while (lp < rp) {
            while (!s[lp].isLetterOrDigit() && lp < rp) lp++
            while (!s[rp].isLetterOrDigit() && rp > lp) rp--
            if (s[lp++] != s[rp--]) return false
        }
        return true
    }

    fun isPalindromeStupid(s: String): Boolean {
        val trimmedString = s.filter(Character::isLetterOrDigit).lowercase()
        return trimmedString == trimmedString.reversed()
    }
}