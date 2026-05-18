package com.leatcode.t219

import com.leatcode.util.print

fun main() {
    Solution().containsNearbyDuplicate(intArrayOf(1, 2, 3, 1), 3).print()
}

class Solution {
    fun containsNearbyDuplicate(nums: IntArray, k: Int): Boolean {
        if (k == 0) return false

        val map = hashMapOf<Int, Int>()
        nums.forEachIndexed { i, n ->
            map[n]?.run { if (map.contains(n) && i - this <= k) return true }
            map[n] = i
        }

        return false
    }
}