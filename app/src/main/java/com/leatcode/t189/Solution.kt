package com.leatcode.t189

import com.leatcode.util.print

fun main() {
    val a = intArrayOf(1, 2, 3, 4, 5)
    Solution().rotate(a, 2)
    a.print()
}

class Solution {
    // 1 2 3 4 5
    fun rotate(nums: IntArray, k: Int) {
        val normalizedK = k % nums.size
        nums.reverse(0, nums.lastIndex)
        nums.reverse(0, normalizedK - 1)
        nums.reverse(normalizedK, nums.lastIndex)
    }

    private fun IntArray.reverse(start: Int, end: Int) {
        var l = start
        var r = end
        while (l < r) {
            val temp = this[l]
            this[l] = this[r]
            this[r] = temp
            l++
            r--
        }
    }

    fun rotate2(nums: IntArray, k: Int) {
        val normalizedK = k % nums.size
        val rotatedNums = nums.takeLast(normalizedK) + nums.take(nums.size - normalizedK)
        for (i in rotatedNums.indices) {
            nums[i] = rotatedNums[i]
        }
    }

}