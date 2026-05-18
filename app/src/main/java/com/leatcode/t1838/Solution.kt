package com.leatcode.t1838

import com.leatcode.util.print
import kotlin.math.max

fun main() {
    Solution().maxFrequency(intArrayOf(1, 4, 8, 13), 5).print()
}

class Solution {
    fun maxFrequency(nums: IntArray, k: Int): Int {
        nums.sort()
        var l = 0
        var sum = 0
        var max = 0
        for (r in 0..nums.lastIndex) {
            sum += nums[r]
            while ((r - l + 1) * nums[r] - sum > k) sum -= nums[l++]
            max = max(max, r - l + 1)
        }
        return max
    }
}