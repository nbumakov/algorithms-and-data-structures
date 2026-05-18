package com.leetcode.t859

import com.leetcode.util.print

fun main() {
    Solution().buddyStrings("abcd", "cbad").print()
}

class Solution {
    fun buddyStrings(s: String, goal: String): Boolean {
        if (s.length != goal.length) return false

        var p1 = 0
        var p2 = s.lastIndex

        while (p1 < p2) {
            when {
                s[p1] == goal[p1] -> p1++
                s[p2] == goal[p2] -> p2--
                else -> return s.swap(p1, p2) == goal
            }
        }

        return (s == goal) && s.containsDuplicateCharacters()
    }

    private fun String.swap(index1: Int, index2: Int): String {
        val charArray = toCharArray()
        val temp = charArray[index1]
        charArray[index1] = charArray[index2]
        charArray[index2] = temp
        return String(charArray)
    }

    private fun String.containsDuplicateCharacters(): Boolean {
        val seenCharacters = HashSet<Char>()
        for (char in this) {
            if (seenCharacters.contains(char)) {
                return true
            }
            seenCharacters.add(char)
        }
        return false
    }
}