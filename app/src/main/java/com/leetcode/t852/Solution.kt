package com.leetcode.t852

import com.leetcode.util.print

fun main() {
    Solution().peakIndexInMountainArray(intArrayOf(3, 5, 3, 2, 0)).print()
}

class Solution {
    fun peakIndexInMountainArray(arr: IntArray): Int {
        var l = 0
        var r = arr.lastIndex

        while (l < r) {
            val mid = (l + r) / 2
            if (arr[mid] < arr[mid + 1]) {
                l = mid + 1
            } else {
                r = mid
            }
        }

        return l
    }
}