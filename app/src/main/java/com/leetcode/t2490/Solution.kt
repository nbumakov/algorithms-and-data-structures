package com.leetcode.t2490

class Solution {
    fun isCircularSentence(sentence: String): Boolean = sentence
            .split(" ")
            .flatMap { listOf(it.first(), it.last()) }
            .let { it.takeLast(it.size - 1) + it.first() }
            .windowed(2, 2)
            .all { it[0] == it[1] }
}