package com.leatcode.t137

import com.leatcode.util.print

fun main() {
    Solution().singleNumber(intArrayOf(30000, 500, 100, 30000, 100, 30000, 100)).print()
}

class Solution {

    //110
    //110
    //110
    //001
    //001
    //001
    //010
    //010
    //010
    //100
    //463
    fun singleNumberFold(nums: IntArray): Int =
        (0..31).fold(0) { acc, bit ->
            acc or ((nums.count { 0 != it and (1 shl bit) } % 3) shl bit)
        }

    fun singleNumber(nums: IntArray): Int {
        var count = 0
        val sortedNums = nums.sorted()
        var previous = sortedNums[0]
        sortedNums.forEach { n ->
            if (n == previous) {
                count++
            } else {
                if (count < 2) return previous
                previous = n
                count = 0
            }
        }
        return previous
    }
}