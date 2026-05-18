package com.leatcode.t75

import com.leatcode.util.print

fun main() {
    val a = intArrayOf(2, 0, 1)
    Solution().sortColorsCounter2(a)
    a.print()
}

class Solution {

    // dutch partitioning problem.
    fun sortColors(nums: IntArray) {
        var red = 0
        var white = 0
        var blue = nums.lastIndex

        while (white <= blue) {
            when (nums[white]) {
                0 -> nums.swap(red++, white++)
                1 -> white++
                2 -> nums.swap(white, blue--)
            }
        }
    }

    private fun IntArray.swap(i: Int, j: Int) {
        val temp = this[i]
        this[i] = this[j]
        this[j] = temp
    }

    fun sortColorsCounter(nums: IntArray) {
        val count = hashMapOf<Int, Int>()
        for (n in nums) {
            count[n] = count.getOrPut(n) { 0 } + 1
        }
        var i = 0
        for (key in count.keys) {
            repeat(count.getOrDefault(key, 0)) {
                nums[i++] = key
            }
        }
    }

    fun sortColorsCounter2(nums: IntArray) {
        val count = IntArray(3)
        for (n in nums) count[n]++

        var k = 0
        for (i in count.indices) {
            for (j in 0 until count[i]) {
                nums[k++] = i
            }
        }
    }
}