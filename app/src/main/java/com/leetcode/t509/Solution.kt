package com.leetcode.t509

class Solution {
    private val cache = hashMapOf<Int, Int>()
    fun fib(n: Int): Int {
        if (n <= 1) return n
        return cache.getOrPut(n) { fib(n - 1) + fib(n - 2) }
    }
}