package com.leetcode.t2390

import com.leetcode.util.print
import java.util.Stack

fun main() {
    Solution().removeStars("leet**cod*e").print()
}

class Solution {
    fun removeStars(s: String): String = with(Stack<Char>()) {
        s.forEach { if (it == '*') pop() else push(it) }
        joinToString("")
    }
}