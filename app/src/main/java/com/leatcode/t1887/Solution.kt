package com.leatcode.t1887

class Solution {
    fun reductionOperations(nums: IntArray): Int = with(sortedMapOf<Int, Int>()) {
        nums.forEach { this[it] = getOrDefault(it, 0) + 1 }

        var count = 0
        while (keys.size > 1) {
            val largestCount = remove(lastKey())!!
            count += largestCount
            this[lastKey()] = this[lastKey()]!! + largestCount
        }

        return count
    }

    fun reductionOperations2(nums: IntArray): Int {
        nums.sort()
        var ups = 0
        var result = 0
        for (i in 1..nums.lastIndex) {
            if (nums[i] > nums[i - 1]) {
                ups++
            }
            result += ups
        }
        return result
    }
}