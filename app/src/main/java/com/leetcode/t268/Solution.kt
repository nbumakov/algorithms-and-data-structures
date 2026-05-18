package com.leetcode.t268

import com.leetcode.util.print

fun main() {
    println(1 xor 1 xor 2)
    Solution().missingNumber(intArrayOf(3, 0, 1)).print()
}

class Solution {

    // 0000
    // 0001
    // 0010
    // 0011
    // 0 1 2 4
    fun missingNumber(nums: IntArray): Int {
        var x = nums.size
        for (i in nums.indices) {
            x = x xor (nums[i] xor i)
        }
        return x
    }
}