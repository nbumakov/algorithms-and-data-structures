package com.leetcode.t2490

class Solution {
    fun isCircularSentence(sentence: String): Boolean = sentence
        .split(" ")
        .flatMap { listOf(it.first(), it.last()) }
        .let { it.takeLast(it.size - 1) + it.first() }
        .windowed(2, 2)
        .all { it[0] == it[1] }
}

class Solution2 {
    fun isCircularSentence(sentence: String): Boolean {
        if (sentence.first() != sentence.last()) return false
        for (i in sentence.indices) {
            if (sentence[i] == ' ') {
                if (sentence[i - 1] != sentence[i + 1]) return false
            }
        }
        return true
    }
}