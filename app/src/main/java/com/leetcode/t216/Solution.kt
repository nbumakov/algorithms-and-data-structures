package com.leetcode.t216

import com.leetcode.util.print

fun main() {
    Solution()
        .combinationSum3(3, 7)
        .forEach { it.print() }
}

class Solution {
    fun combinationSum3(k: Int, n: Int): List<List<Int>> {
        val result = mutableListOf<List<Int>>()
        val cur = mutableSetOf<Int>()
        var sum = 0

        fun backtrack(i: Int) {
            if (cur.size == k && sum == n) result.add(cur.toList())
            if (cur.size >= k || sum > n) return

            for (j in i..9) {
                cur.add(j)
                sum += j
                backtrack(j + 1)
                sum -= j
                cur.remove(j)
            }
        }
        backtrack(1)
        return result
    }
}