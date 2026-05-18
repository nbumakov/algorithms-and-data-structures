package com.leatcode.t153

import com.leatcode.util.print

fun main() {
    Solution().findMin(intArrayOf(2, 1)).print()
}

class Solution {
    fun findMin(nums: IntArray): Int {
        var lo = 0
        var hi = nums.lastIndex
        var min = nums[0]

        while (lo <= hi) {
            if(nums[lo] <= nums[hi]){
                min = minOf(min, nums[lo])
                break
            }

            val mid = (lo + hi) / 2
            min = minOf(min, nums[mid])

            if (nums[lo] <= nums[mid]) {
                lo = mid + 1
            } else {
                hi = mid - 1
            }
        }

        return min
    }
}