package com.leatcode.t2134

import com.leatcode.util.print


/**
 *  [1,1,1,0,0,1,0,1,1,0]
 *  Count the minimum amount of zeros in the window of size c1.
 */
class Solution {
    fun minSwaps(nums: IntArray): Int {
        val c1 = nums.sum()
        var zeros = (0 until c1).count { nums[it] < 1 }
        return nums.indices.minOf { i ->
            if (nums[i] == 0) zeros--
            if (nums[(i + c1) % nums.size] == 0) zeros++
            zeros
        }
    }
}

fun main() {
    Solution().minSwaps(intArrayOf(1, 1, 1, 0, 0, 1, 0, 1, 1, 0)).print()
}