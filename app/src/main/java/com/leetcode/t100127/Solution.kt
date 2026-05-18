package com.leetcode.t100127

import com.leetcode.util.print

fun main() {
    Solution().distributeCandies(5, 2).print()
    Solution().distributeCandies(3, 3).print()
}

//  ***|||
class Solution {
    fun distributeCandies(n: Int, limit: Int): Long {
        if (n > 3 * limit) return 0
        var result = comb(n + 2)
        if (n > limit) result -= 3 * comb(n - limit + 1)
        if (n - 2 >= 2 * limit) result += 3 * comb(n - 2 * limit)
        return result
    }

    private fun comb(n: Int): Long = 1L * n * (n - 1) / 2
}