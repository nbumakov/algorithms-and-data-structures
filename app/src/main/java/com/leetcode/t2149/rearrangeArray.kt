package com.leetcode.t2149

class Solution {
    fun rearrangeArray(nums: IntArray): IntArray = with(nums.asSequence()) {
        val positiveNums = filter { it > 0 }.iterator()
        val negativeNums = filter { it < 0 }.iterator()

        return IntArray(nums.size) {
            if (it % 2 == 0) positiveNums.next() else negativeNums.next()
        }
    }
}
