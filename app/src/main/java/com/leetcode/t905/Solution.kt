package com.leetcode.t905

class Solution {

    fun sortArrayByParitySwap2(nums: IntArray) = nums.apply {
        var p1 = 0
        var p2 = nums.lastIndex
        while (p1 < p2) {
            while (p1 < p2 && this[p1] % 2 == 0) p1++
            while (p2 > p1 && this[p2] % 2 == 1) p2--
            this[p1] = this[p2].also { this[p2] = this[p1] }
            p1++; p2--
        }
    }

    fun sortArrayByParitySwap(nums: IntArray): IntArray {
        var p1 = 0
        var p2 = nums.lastIndex

        while (p1 < p2) when {
            nums[p1] % 2 == 0 -> p1++
            else -> nums.swap(p1, p2--)
        }

        return nums
    }

    private fun IntArray.swap(i: Int, j: Int) {
        val temp = this[i]
        this[i] = this[j]
        this[j] = temp
    }

    fun sortArrayByParity(nums: IntArray): IntArray =
        nums.partition { it % 2 == 0 }
            .run { first + second }
            .toIntArray()
}