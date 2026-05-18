package com.leetcode.t42

import com.leetcode.util.print
import java.util.Stack

fun main(){
    Solution().trap(intArrayOf(0,1,0,2,1,0,1,3,2,1,2,1)).print()
}

class Solution {

    fun trap(height: IntArray): Int {
        var lMax = height[0]
        var rMax = height.last()
        var l = 0
        var r = height.lastIndex
        var trapped = 0
        while (l < r) {
            if (height[l] < height[r]) {
                lMax = maxOf(lMax, height[l])
                trapped += (lMax - height[l]).coerceAtLeast(0)
                l++
            } else {
                rMax = maxOf(rMax, height[r])
                trapped += (rMax - height[r]).coerceAtLeast(0)
                r--
            }
        }
        return trapped
    }

    fun trapWithStack(height: IntArray): Int {
        val stack = Stack<Pair<Int, Int>>().apply {
            var max = 0
            height.forEach {
                max = maxOf(it, max)
                push(it to max)
            }
        }

        var rMax = 0
        var trappedWater = 0

        while (stack.isNotEmpty()) {
            val (h, lMax) = stack.pop()
            trappedWater += (minOf(rMax, lMax) - h).coerceAtLeast(0)
            rMax = maxOf(rMax, h)
        }

        return trappedWater
    }

}