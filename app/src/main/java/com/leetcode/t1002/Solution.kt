package com.leetcode.t1002

class Solution {
    fun commonChars(words: Array<String>): List<String> {
        val freq = words.map { word ->
            word.associateWith { char ->
                word.count { it == char }}
        }

        val common = freq
            .map { it.keys }
            .reduce { acc, set -> acc.intersect(set) }

        return common.flatMap { char ->
            val minCount = freq.mapNotNull { it[char] }.minOrNull() ?: 0
            List(minCount) { char.toString() }
        }
    }
}