package com.leetcode.t844


class Solution {
    fun backspaceCompare(s: String, t: String): Boolean {
        fun String.parse() = ArrayDeque<Char>().apply {
            this@parse.forEach { char ->
                if (char != '#') {
                    add(char)
                } else if (isNotEmpty()) {
                    removeLast()
                }
            }
        }

        return s.parse() == t.parse()
    }

    fun backspaceCompare2(s: String, t: String): Boolean {
        var i = s.lastIndex
        var j = t.lastIndex
        TODO()
    }
}