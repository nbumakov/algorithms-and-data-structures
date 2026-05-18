package com.leatcode.t1331

class Solution {
    fun arrayRankTransform(arr: IntArray): IntArray {
        val rankMap = arr.toSet()
            .sorted()
            .withIndex().associate { it.value to it.index + 1 }
        return arr.map { rankMap[it]!! }.toIntArray()
    }
}