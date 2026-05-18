package com.leetcode.t55

import com.leetcode.util.print

fun main() {
    Solution().canJump(intArrayOf(2, 0, 0)).print()
}

class Solution {

    fun canJump(nums: IntArray): Boolean {
        val dp = BooleanArray(nums.size)
        dp[nums.lastIndex] = true

        for (i in nums.lastIndex - 1 downTo 0) {
            for (j in i + 1..(i + nums[i]).coerceAtMost(nums.lastIndex)) {
                if (dp[j]) {
                    dp[i] = true
                    break
                }
            }
        }
        return dp[0]
    }


    // top-down + memo
    fun canJump1(nums: IntArray): Boolean {

        val visited = BooleanArray(nums.size)

        fun dfs(i: Int): Boolean {
            if (i >= nums.lastIndex) return true
            if (visited[i]) return false
            visited[i] = true
            return (i + 1..i + nums[i])
                .any(::dfs)
        }

        return dfs(0)
    }
}