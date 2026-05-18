package com.leatcode.t2390

import com.leatcode.util.print
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