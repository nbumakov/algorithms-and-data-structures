package com.leatcode.t77

import com.leatcode.util.print

fun main() {
    Solution().combine(4, 2).print()
}

class Solution {
    fun combine(n: Int, k: Int): List<List<Int>> {
        val result = mutableListOf<List<Int>>()
        fun backtrack(curr: MutableList<Int>, firstN: Int) {
            if (curr.size == k) {
                result.add(curr.toList())
                return
            }

            if (n - firstN + curr.size + 1 < k) {
                return
            }

            for (num in firstN..n) {
                curr.add(num)
                backtrack(curr, num + 1)
                curr.removeAt(curr.lastIndex)
            }
        }
        backtrack(mutableListOf(), 1)
        return result
    }
}