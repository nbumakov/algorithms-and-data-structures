package com.leatcode.t974

import com.leatcode.util.print

fun main() {
    Solution().subarraysDivByK(intArrayOf(4, 5, 0, -2, -3, 1), 5).print()
}

class Solution {
    fun subarraysDivByK(nums: IntArray, k: Int): Int {
        var prefixMod = 0
        val prefixMods = IntArray(nums.size + 1)
        for (i in nums.indices) {
            prefixMod = (prefixMod + nums[i]) % k
            if (prefixMod < 0) prefixMod += k
            prefixMods[i + 1] = prefixMod
        }

        return prefixMods
            .groupBy { it }
            .map { it.value.size }
            .filter { it > 1 }
            .fold(0) { acc, i -> acc + i * (i - 1) / 2 }
    }
}