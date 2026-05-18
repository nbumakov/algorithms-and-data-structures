package com.leatcode.t58

/**
 * Given a string s consisting of words and spaces, return the length of the last word in the string.
 * A word is a maximal substring consisting of non-space characters only.
 */
class Solution {
    fun lengthOfLastWord(s: String): Int =
        s.trim()
            .split(" ")
            .last()
            .length
}

fun main() {
    println(Solution().lengthOfLastWord("   fly me   to   the moon  "))
}