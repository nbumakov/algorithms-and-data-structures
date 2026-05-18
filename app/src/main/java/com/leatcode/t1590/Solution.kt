package com.leatcode.t1590

import com.leatcode.util.print
import kotlin.math.min

fun main() {
    Solution()
        .minSubarray(intArrayOf(3, 1, 4, 2), 6)
        .print()
}

class Solution {
    fun minSubarray(nums: IntArray, p: Int): Int {
        val prefixSum = nums.scan(0) { acc, i -> (acc + i) % p }
        val target = prefixSum.last().takeIf { it > 0 } ?: return 0
        val map = mutableMapOf<Int, Int>()
        var minLength = Int.MAX_VALUE
        prefixSum.forEachIndexed { index, sum ->
            val complement = (sum - target + p) % p
            map[complement]?.let { complementIndex ->
                minLength = min(minLength, index - complementIndex)
            }
            map[sum] = index
        }
        return if(minLength < nums.size) minLength else -1
    }
}