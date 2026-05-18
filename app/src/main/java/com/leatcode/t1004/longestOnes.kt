package com.leatcode.t1004

import com.leatcode.util.print
import kotlin.math.max

fun main() {
    Solution().longestOnes(intArrayOf(0, 0, 1, 1, 0, 0, 1, 1, 1, 0, 1, 1, 0, 0, 0, 1, 1, 1, 1), 3).print()
}

class Solution {
    fun longestOnes(nums: IntArray, k: Int): Int {
        var max = 0
        var flips = k
        var l = 0

        for (r in 0..nums.lastIndex) {
            if (nums[r] == 0) {
                if (flips > 0) {
                    flips--
                } else {
                    while (nums[l] == 1) l++
                    l++
                }
            }
            max = max(max, r - l + 1)
        }

        return max
    }
}