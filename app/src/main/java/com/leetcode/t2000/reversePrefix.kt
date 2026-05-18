package com.leetcode.t2000

class Solution {
    fun reversePrefix(word: String, ch: Char): String {
        val index = word.indexOf(ch)
        if (index == -1) return word
        return word.substring(0..index).reversed() + word.substring(index+1..word.lastIndex)
    }
}

class SolutionSD {
    fun reversePrefix(word: String, ch: Char): String = String(
        word.toCharArray().apply { reverse(0, indexOf(ch)) }
    )
}