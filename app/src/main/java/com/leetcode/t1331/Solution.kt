package com.leetcode.t1331

class Solution {
    fun arrayRankTransform(arr: IntArray): IntArray {
        val rankMap = arr.toSet()
            .sorted()
            .withIndex().associate { it.value to it.index + 1 }
        return arr.map { rankMap[it]!! }.toIntArray()
    }
}

class Solution2 {
    fun arrayRankTransform(arr: IntArray): IntArray {
        val sorted = arr.sortedArray()
        val rankMap = HashMap<Int, Int>(sorted.size)
        var rank = 0
        for (v in sorted) {
            if (v !in rankMap) {
                rank++
                rankMap[v] = rank
            }
        }
        return IntArray(arr.size) { rankMap.getValue(arr[it]) }
    }
}
