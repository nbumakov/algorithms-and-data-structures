package com.leetcode.t3634

import com.leetcode.util.print
import kotlin.math.min

fun main() {
    Solution().minRemoval(intArrayOf(2, 1, 5), 2).print()
    Solution().minRemoval(intArrayOf(1, 6, 2, 9), 3).print()
    Solution().minRemoval(intArrayOf(70, 410, 277, 258, 365, 207, 272, 410), 1).print()
}

class Solution {
    fun minRemoval(nums: IntArray, k: Int): Int {
        nums.sort()
        var removals = Integer.MAX_VALUE
        for (i in nums.indices) {
            val limit = nums[i].toLong() * k
            var lo = i
            var hi = nums.size
            while (lo < hi) {
                val mid = (lo + hi) / 2
                if (nums[mid] <= limit) lo = mid + 1 else hi = mid
            }
            removals = min(removals, i + nums.size - lo)
        }
        return removals
    }
}

// Two-pointer instead of binary search: as i advances, limit = nums[i]*k can only grow,
// so r never moves backward — O(n) scan instead of O(n log n).
class Solution2 {
    fun minRemoval(nums: IntArray, k: Int): Int {
        nums.sort()
        var removals = Integer.MAX_VALUE
        var r = 0
        for (i in nums.indices) {
            if (r < i) r = i
            val limit = nums[i].toLong() * k
            while (r < nums.size && nums[r].toLong() <= limit) r++
            removals = min(removals, i + nums.size - r)
        }
        return removals
    }
}
