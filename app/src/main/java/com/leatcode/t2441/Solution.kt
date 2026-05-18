package com.leatcode.t2441

import kotlin.math.absoluteValue
import kotlin.math.max

class Solution {
    // Approach 3: Two Pass Hash Set
    fun findMaxK(nums: IntArray): Int {
        val negatives = nums.filter { it < 0 }.toSet()
        return nums.filter { it > 0 && negatives.contains(-it) }
            .maxOrNull() ?: -1
    }
}


class Solution2 {
    // Approach 4: One Pass Hash Set
    fun findMaxK(nums: IntArray): Int {
        val seen = mutableSetOf<Int>()
        var max = -1
        for (i in nums.indices) {
            if (seen.contains(-nums[i])) {
                max = max(max, nums[i].absoluteValue)
            } else {
                seen.add(nums[i])
            }
        }
        return max
    }
}