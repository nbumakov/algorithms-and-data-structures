package com.leetcode.t20

class Solution {

    fun isValid(s: String): Boolean {
        val stack = ArrayDeque<Char>()
        s.asIterable().forEach {
            if (BracketsMap.containsKey(it)) {
                if (stack.isEmpty()) return false
                if (stack.removeLast() != BracketsMap[it]) return false
            } else {
                stack.add(it)
            }
        }
        return stack.isEmpty()
    }

    companion object {
        private val BracketsMap: Map<Char, Char> = mapOf(
            ')' to '(',
            ']' to '[',
            '}' to '{'
        )
    }
}