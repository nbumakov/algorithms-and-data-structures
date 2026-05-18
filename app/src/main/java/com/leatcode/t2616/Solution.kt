package com.leatcode.t2616

import com.leatcode.util.print
import java.util.PriorityQueue
import kotlin.math.abs

fun main() {
    Solution().minimizeMax(intArrayOf(3, 4, 2, 3, 2, 1, 2), 3).print()
}

class Solution {
    fun minimizeMax(nums: IntArray, p: Int): Int {
        if (p == 0) return 0

        nums.sort()

        var l = 0
        var r = nums.last() - nums.first()

        var res = r

        while (l <= r) {
            val mid = (l + r) / 2
            var count = 0

            var i = 0
            while (i < nums.lastIndex) if (nums[i + 1] - nums[i] <= mid) {
                i += 2
                count++
            } else i++

            if (count >= p) res = minOf(res, mid)
            if (count >= p) r = mid - 1 else l = mid + 1
        }
        return res
    }
}