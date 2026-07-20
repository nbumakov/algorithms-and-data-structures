package com.leetcode.t1081

import com.leetcode.util.print

class Solution {
    fun smallestSubsequence(s: String): String {
        val lastPosition = IntArray(26)
        s.forEachIndexed { index, c -> lastPosition[c - 'a'] = index }

        val stack = StringBuilder()      // используем как стек
        val inStack = BooleanArray(26)

        s.forEachIndexed { i, c ->
            if (inStack[c - 'a']) return@forEachIndexed   // букву уже взяли

            // вершина больше текущей И ещё встретится позже -> выкидываем
            while (stack.isNotEmpty() && stack.last() > c && lastPosition[stack.last() - 'a'] > i) {
                inStack[stack.last() - 'a'] = false
                stack.deleteAt(stack.length - 1)
            }

            stack.append(c)
            inStack[c - 'a'] = true
        }

        return stack.toString()
    }
}

fun main() {
    Solution().smallestSubsequence("cbacdcbc")
        .print()
}