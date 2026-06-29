package com.leetcode.t1967

// Approach 1: Brute Force Matching
class Solution {
    fun numOfStrings(patterns: Array<String>, word: String): Int =
        patterns.count { word.contains(it) }
}