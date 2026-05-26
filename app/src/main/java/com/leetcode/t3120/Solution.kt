package com.leetcode.t3120

class Solution {
    fun numberOfSpecialChars(word: String): Int {
        val set = word.toSet()
        return set.count { it.isLowerCase() && it.uppercaseChar() in set }
    }
}
