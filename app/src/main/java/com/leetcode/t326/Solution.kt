package com.leetcode.t326

import com.leetcode.util.print

fun main() {
    Solution().isPowerOfThree(27).print()
    Solution().isPowerOfThree(27).print()
}

class Solution {
    fun isPowerOfThree(n: Int): Boolean {
        if (n <= 1) return false

        var x = n
        while (x != 1 && x % 3 == 0) x /= 3
        return x == 1
    }
}