package com.leatcode.t1200

class Solution {
    fun minimumAbsDifference(arr: IntArray): List<List<Int>> {
        val result = mutableListOf<List<Int>>()
        arr.sort()
        var min = Int.MAX_VALUE
        for (i in 1..arr.lastIndex) {
            min = minOf(min, arr[i] - arr[i - 1])
        }
        for (i in 1..arr.lastIndex) {
            val diff = arr[i] - arr[i - 1]
            if (diff == min) {
                result.add(listOf(arr[i - 1], arr[i]))
            }
        }
        return result
    }
}