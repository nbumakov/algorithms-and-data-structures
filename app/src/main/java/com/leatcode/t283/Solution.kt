package com.leatcode.t283

import com.leatcode.util.print

fun main() {
    val array = intArrayOf(0, 1, 0, 3, 12)
    Solution().moveZeroes(array)
    array.joinToString().print()
}

class Solution {
    fun moveZeroes(nums: IntArray) {
        var i = 0
        for (n in nums) {
            if (n != 0) {
                nums[i++] = n
            }
        }

        while (i < nums.size) {
            nums[i++] = 0
        }
    }
}