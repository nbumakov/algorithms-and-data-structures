package com.leetcode.t1768

class Solution {
    fun mergeAlternately(word1: String, word2: String): String {
        var i = 0
        val result = StringBuilder()
        while (i < maxOf(word1.length, word2.length)) {
            if (i < word1.length) result.append(word1[i])
            if (i < word2.length) result.append(word2[i])
            i++
        }
        return result.toString()
    }
}