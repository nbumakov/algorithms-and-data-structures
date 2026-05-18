package com.leetcode.t1408

class Solution {
    fun stringMatching(words: Array<String>): List<String> =
        words.filter { word ->
            words.any { it.length > word.length && it.contains(word) }
        }
}