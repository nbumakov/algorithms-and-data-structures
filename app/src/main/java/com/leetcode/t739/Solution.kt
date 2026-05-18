package com.leetcode.t739

import com.leetcode.util.print
import java.util.Stack

fun main() {
    Solution()
        .dailyTemperatures(intArrayOf(73,74,75,71,69,72,76,73))
        .joinToString()
        .print()
}

/**
 * Input: temperatures = [73,74,75,71,69,72,76,73]
 * Output: [1,1,4,2,1,1,0,0]
 */
class Solution {
    fun dailyTemperatures(temperatures: IntArray): IntArray {
        val result = IntArray(temperatures.size) { 0 }
        val stack = Stack<Pair<Int, Int>>()

        temperatures.forEachIndexed { index, t ->
            while (stack.isNotEmpty() && stack.peek().second < t) {
                val previousTemp = stack.pop()
                result[previousTemp.first] = index - previousTemp.first
            }
            stack.push(index to t)
        }

        return result
    }
}