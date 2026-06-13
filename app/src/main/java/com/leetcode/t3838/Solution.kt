package com.leetcode.t3838

class Solution {
    fun mapWordWeights(words: Array<String>, weights: IntArray): String =
        words.map { it.sumOf { weights[it - 'a'] } % 26 }
            .joinToString("") { ('z' - it).toString() }
}

class Solution2 {
    fun mapWordWeights(words: Array<String>, weights: IntArray): String = words
        .joinToString("") { w ->
            ('z' - w.sumOf { c -> weights[c - 'a'] } % 26).toString()
        }
}