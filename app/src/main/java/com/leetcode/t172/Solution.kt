package com.leetcode.t172

import com.leetcode.util.print

fun main() {
    Solution().trailingZeroes(5).print()
}
class Solution {
    fun trailingZeroes(n: Int): Int {
        var zeros = 0
        var x = 5
        while (x <= n){
            zeros += n / x
            x *= 5
        }
        return zeros
    }
}