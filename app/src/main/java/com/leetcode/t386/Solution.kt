package com.leetcode.t386

class Solution {
    fun lexicalOrder(n: Int): List<Int> = buildList {
        fun dfs(x: Int) {
            if (x > n) return
            add(x)
            (0..9).forEach { dfs(x * 10 + it) }
        }
        (0..9).forEach(::dfs)
    }
}