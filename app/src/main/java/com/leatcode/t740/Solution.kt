package com.leatcode.t740

import com.leatcode.util.print

fun main() {
    Solution().deleteAndEarn2(intArrayOf(1, 2, 3, 15, 16, 17, 18)).print()
}

class Solution {

    // rec + memo O(n + k)
    fun deleteAndEarn(nums: IntArray): Int {
        val sums = hashMapOf<Int, Int>()
        nums.forEach { sums[it] = sums.getOrDefault(it, 0) + it }
        val max = nums.max()
        val cache = hashMapOf<Int, Int>()


        fun dp(i: Int): Int {
            if (i < 0) return 0
            if (cache.containsKey(i)) return cache[i]!!
            return maxOf(dp(i - 1), dp(i - 2) + sums.getOrDefault(i, 0))
                .also { cache[i] = it }
        }

        return dp(max)
    }

    // first idea, dp O(nlogn)
    fun deleteAndEarn1(nums: IntArray): Int {
        val sums = nums.groupBy { it }
            .map { it.key to it.value.sum() }
            .sortedBy { it.first }
        val dp = IntArray(sums.size + 2)
        var i = 2
        for (k in 0..sums.lastIndex) {
            if (k == 0 || sums[k].first - sums[k - 1].first > 1) {
                dp[i] = dp[i - 1] + sums[k].second
            } else {
                dp[i] = maxOf(dp[i - 1], dp[i - 2] + sums[k].second)
            }
            i++
        }
        return dp.last()
    }

    // dp, space optimization
    fun deleteAndEarn2(nums: IntArray): Int {
        val sums = hashMapOf<Int, Int>()
        nums.forEach { sums[it] = sums.getOrDefault(it, 0) + it }
        val max = nums.max()!!

        val dp = IntArray(3)
        for (k in 0..max) {
            dp[k % 3] = maxOf(dp[(k + 2) % 3], dp[(k + 1) % 3] + sums.getOrDefault(k, 0))
        }
        return dp[max % 3]
    }
}