package com.leetcode.t1287

class Solution {
    fun findSpecialInteger(arr: IntArray): Int {
        val candidates = mutableSetOf<Int>()
        for (i in 0..arr.lastIndex step (arr.size / 4).coerceAtLeast(1)) {
            candidates.add(arr[i])
        }
        return candidates.first { arr.upperBound(it) - arr.lowerBound(it) >= arr.size / 4 }
    }

    private fun IntArray.lowerBound(target: Int): Int {
        var l = 0
        var r = lastIndex
        while (l <= r) {
            val mid = (r + l) / 2
            when {
                this[mid] >= target -> r = mid - 1
                else -> l = mid + 1
            }
        }
        return l
    }

    private fun IntArray.upperBound(target: Int): Int {
        var l = 0
        var r = lastIndex
        while (l <= r) {
            val mid = (r + l) / 2
            when {
                this[mid] > target -> r = mid - 1
                else -> l = mid + 1
            }
        }
        return r
    }
}