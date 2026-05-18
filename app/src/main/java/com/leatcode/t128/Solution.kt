package com.leatcode.t128

import com.leatcode.util.print
import java.lang.Integer.max

fun main() {
    Solution().longestConsecutive(intArrayOf(100, 4, 200, 1, 3, 2)).print()
}

class Solution {
    fun longestConsecutive(nums: IntArray): Int {
        val set = nums.toSet()
        var max = 0

        for (n in set) {
            if (set.contains(n - 1)) continue

            var next = n + 1
            while (set.contains(next)) next++
            max = max(max, next - n)
        }

        return max
    }

}