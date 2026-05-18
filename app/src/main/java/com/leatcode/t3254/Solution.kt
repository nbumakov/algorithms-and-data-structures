package com.leatcode.t3254

fun main() {
//    Solution().resultsArray(intArrayOf(1, 2, 3, 4, 3, 2, 5), 3).forEach {
//        print("$it ")
//    }

    Solution()
        .resultsArray(intArrayOf(1, 4), 1)
        .forEach { print("$it ") }
}

class Solution {
    // 1,2,3,4,3,2,5
    fun resultsArray(nums: IntArray, k: Int): IntArray {
        var lastBreak = 0
        val res = IntArray(nums.size - k + 1)
            .apply { this[0] = nums[0] }

        for (i in 1..nums.lastIndex) {
            if (nums[i] != nums[i - 1] + 1) lastBreak = i
            if (i >= k - 1) {
                res[i - k + 1] = if (i - lastBreak + 1 >= k) nums[i] else -1
            }
        }

        return res
    }
}