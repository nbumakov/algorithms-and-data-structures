package com.leetcode.t3016

import com.leetcode.util.print

fun main() {
    Solution().minimumPushes("xyzxyzxyzxyz")
        .print()
}

class Solution {
    fun minimumPushes(word: String): Int {
        val count = IntArray(26)
        word.forEach { count[it - 'a']++ }
        val mapping = count
            .withIndex()
            .sortedByDescending { it.value }
            .withIndex()
            .associate { it.value.index to it.index }

        return word.sumOf { mapping[it - 'a']!! / 8 + 1 }
    }
}

class Solution2 {
    fun minimumPushes(word: String): Int = with(IntArray(26)) {
        for (c in word) this[c - 'a']++
        sortDescending()
        indices.sumOf { (it / 8 + 1) * this[it] }
    }
}