package com.leetcode.t1089

class Solution {
    fun duplicateZeros(arr: IntArray) {
        var i = 0
        while (i in 0 until arr.lastIndex) {
            if (arr[i] == 0) {
                for (j in arr.lastIndex downTo i + 2) {
                    arr[j] = arr[j - 1]
                }
                arr[i + 1] = 0
                i++
            }
            i++
        }
    }
}