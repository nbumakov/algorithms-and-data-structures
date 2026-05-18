package com.leetcode.t316

import com.leetcode.util.print

fun main() {
//    Solution().removeDuplicateLetters("cbacdcbc").print()
    Solution().removeDuplicateLetters("abacb").print()
}

class Solution {
    fun removeDuplicateLetters(s: String): String {
        val lastPosition = hashMapOf<Char, Int>().apply {
            for (i in s.indices) this[s[i]] = i
        }

        val seen = hashSetOf<Char>()
        val stack = ArrayDeque<Char>()

        for (i in s.indices) {
            if (seen.contains(s[i])) continue
            while (stack.isNotEmpty() && s[i] < stack.last() && lastPosition[stack.last()]!! > i) {
                seen.remove( stack.removeLast())
            }
            seen.add(s[i])
            stack.add(s[i])
        }

        return stack.joinToString("")
    }
}