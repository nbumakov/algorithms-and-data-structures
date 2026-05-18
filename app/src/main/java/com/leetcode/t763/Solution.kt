package com.leetcode.t763

import com.leetcode.util.print

fun main() {
    Solution().partitionLabels("ababcbacadefegdehijhklij").print()
    Solution().partitionLabels("eccbbbbdec").print()
}

class Solution {
    fun partitionLabels(s: String): List<Int> {
        var end = 0
        val ends = hashMapOf<Char, Int>()
        var anchor = 0
        val result = mutableListOf<Int>()
        for (i in s.indices) {
            val char = s[i]
            end = maxOf(end, ends.getOrPut(char) { s.lastIndexOf(char) })
            if (end == i) {
                result.add(end - anchor + 1)
                anchor = i + 1
            }
        }
        return result
    }
}