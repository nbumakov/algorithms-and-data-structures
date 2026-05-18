package com.leatcode.t11


class Solution {
    fun maxArea(height: IntArray): Int {
        var max = 0
        var l = 0
        var r = height.lastIndex

        while (l < r) {
            max = maxOf(max, minOf(height[r], height[l]) * (r - l))
            if (height[l] < height[r]) l++ else r--
        }

        return max
    }
}