package com.leatcode.t209

import com.leatcode.util.print


fun main() {
    Solution().minSubArrayLen(7, intArrayOf(2, 3, 1, 2, 4, 3)).print()
}

class Solution {
    fun minSubArrayLen(target: Int, nums: IntArray): Int {
        var p1 = 0
        var p2 = 0
        var sum = nums[0]
        var minLength = Int.MAX_VALUE

        val shrinkWindow = {
            while (sum >= target) {
                minLength = minOf(minLength, p2 - p1 + 1)
                sum -= nums[p1++]
            }
        }

        while (p2 < nums.lastIndex) {
            shrinkWindow()
            sum += nums[++p2]
        }

        shrinkWindow()

        return if (minLength == Int.MAX_VALUE) 0 else minLength
    }
}