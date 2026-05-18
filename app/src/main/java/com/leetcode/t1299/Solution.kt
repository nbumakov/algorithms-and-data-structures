package com.leetcode.t1299

class Solution {
    fun replaceElements(arr: IntArray): IntArray {
        var max = -1
        for (i in arr.lastIndex downTo 0) {
            val newMax = maxOf(max, arr[i])
            arr[i] = max
            max = newMax
        }
        return arr
    }
}