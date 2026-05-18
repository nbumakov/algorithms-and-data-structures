package com.leatcode.t941

import com.leatcode.util.print

fun main() {
    Solution().validMountainArray(intArrayOf(1, 3, 2)).print()
}

class Solution {
    fun validMountainArray(arr: IntArray): Boolean {
        var i = 0
        while (i < arr.lastIndex && arr[i] < arr[i + 1]) {
            i++
        }

        if (i == 0 || i == arr.lastIndex) {
            return false
        }

        while (i < arr.lastIndex && arr[i] > arr[i + 1]) {
            i++
        }

        return i == arr.lastIndex
    }
}