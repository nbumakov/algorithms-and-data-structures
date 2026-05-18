package com.leatcode.t1762

class Solution {
    fun findBuildings(heights: IntArray): IntArray {
        var max = heights.last()
        val oceanViewIndexes = mutableListOf(heights.size - 1)

        for (i in heights.size - 2 downTo 0) {
            if (heights[i] > max) {
                oceanViewIndexes.add(i)
                max = heights[i]
            }
        }

        return oceanViewIndexes.reversed().toIntArray()
    }
}

class Solution2 {
    fun findBuildings(heights: IntArray): IntArray {
        val stack = mutableListOf<Int>()
        for (i in heights.indices) {
            while (stack.isNotEmpty() && heights[i] >= heights[stack.last()]) {
                stack.removeAt(stack.lastIndex)
            }
            stack.add(i)
        }
        return stack.toIntArray()
    }
}