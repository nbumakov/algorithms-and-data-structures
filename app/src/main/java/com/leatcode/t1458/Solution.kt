package com.leatcode.t1458

class Solution {

    //TODO: make dp

    // Approach 1: Top-Down Dynamic Programming
    fun maxDotProduct(nums1: IntArray, nums2: IntArray): Int {
        val cache = Array(nums1.size) { IntArray(nums2.size) }
        fun dfs(i: Int, j: Int): Int {
            if (i > nums1.lastIndex || j > nums2.lastIndex) return 0

            if (cache[i][j] != 0) return cache[i][j]

            return maxOf(
                nums1[i] * nums2[j] + dfs(i + 1, j + 1),
                dfs(i + 1, j),
                dfs(i, j + 1)
            ).also { cache[i][j] = it }
        }

        var firstMax = Int.MIN_VALUE
        var secondMax = Int.MIN_VALUE
        var firstMin = Int.MAX_VALUE
        var secondMin = Int.MAX_VALUE

        for (num in nums1) {
            firstMax = firstMax.coerceAtLeast(num)
            firstMin = firstMin.coerceAtMost(num)
        }

        for (num in nums2) {
            secondMax = secondMax.coerceAtLeast(num)
            secondMin = secondMin.coerceAtMost(num)
        }

        if (firstMax < 0 && secondMin > 0) {
            return firstMax * secondMin
        }

        if (firstMin > 0 && secondMax < 0) {
            return firstMin * secondMax
        }

        return dfs(0, 0)
    }
}