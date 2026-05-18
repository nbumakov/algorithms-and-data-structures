package com.leatcode.t896

class Solution {

//TODO
//    fun longestMonotonicSunArray(nums: IntArray) {
//        var max = 0
//        var start = 0
//        nums.withIndex()
//            .windowed(2)
//            .map { IndexedValue(it[0].index, it[0].value - it[1].value) }
//            .fold(mutableListOf<Mu())
//
//
//    }


    fun isMonotonic3(nums: IntArray) =
        nums.asSequence().windowed(2)
            .map { it[0] - it[1] }
            .filter { it != 0 }
            .run { all { it > 0 } || all { it < 0 } }

    fun isMonotonic(nums: IntArray): Boolean {
        var isIncreasing = true
        var isDecreasing = true

        for (i in 1..nums.lastIndex) {
            if (isIncreasing) {
                isIncreasing = nums[i - 1] <= nums[i]
            }
            if (isDecreasing) {
                isDecreasing = nums[i - 1] >= nums[i]
            }
            if (!isIncreasing && !isDecreasing) break
        }

        return isIncreasing || isDecreasing
    }

    fun isMonotonic2(nums: IntArray): Boolean {
        val isIncreasing by lazy {
            var previous = Int.MIN_VALUE
            nums.forEach { if (it >= previous) previous = it else return@lazy false }
            true
        }

        val isDecreasing by lazy {
            var previous = Int.MAX_VALUE
            nums.forEach { if (it <= previous) previous = it else return@lazy false }
            true
        }

        return isDecreasing || isIncreasing
    }
}