package com.leatcode.t136

import com.leatcode.util.print

fun main() {
    Solution().singleNumber(intArrayOf(2, 2, 1, 1, 5)).print()
}

class Solution {
    fun singleNumber(nums: IntArray): Int = with(hashSetOf<Int>()) {
        for (n in nums) if (contains(n)) remove(n) else add(n)
        first()
    }

    fun singleNumberXor(nums: IntArray): Int =
        nums.reduce { acc: Int, n: Int -> acc xor n }
}