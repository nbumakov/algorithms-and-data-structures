package com.leetcode.t1491

class Solution {

    fun average(salary: IntArray): Double {
        var min = Int.MAX_VALUE
        var max = Int.MIN_VALUE
        var sum = 0.0
        salary.forEach {
            sum += it
            min = minOf(min, it)
            max = maxOf(max, it)
        }
        return (sum - min - max) / (salary.size - 2)
    }

    fun average2(salary: IntArray): Double {
        val min = salary.min()
        val max = salary.max()
        return salary.asSequence().filter { it != min && it != max }.average()
    }
}