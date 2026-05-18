package com.leatcode.t1544

import java.lang.StringBuilder

class Solution {
    fun makeGood(s: String): String {
        val stack = ArrayDeque<Char>()
        s.forEach {
            if (stack.isEmpty() || stack.last() == it || stack.last().uppercase() != it.uppercase()) {
                stack.add(it)
            } else {
                stack.removeLast()
            }
        }

        return stack.joinToString("")
    }

}

class SolutionSD {
    fun makeGood(s: String): String = buildString {
        for (c in s) {
            if (isNotEmpty() && c != last() && c.lowercase() == last().lowercase()) {
                deleteAt(lastIndex)
            } else {
                append(c)
            }
        }
    }

}