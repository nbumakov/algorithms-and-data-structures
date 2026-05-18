package com.leetcode.t599

class Solution {
    fun findRestaurant(list1: Array<String>, list2: Array<String>): Array<String> {
        val map = HashMap<String, Int>()
        list1.forEachIndexed { index, s ->
            if (!map.contains(s)) map[s] = index
        }
        val result = mutableListOf<String>()
        var min = Int.MAX_VALUE
        list2.forEachIndexed { index, s ->
            if (map.contains(s)) {
                val indexesSum = map[s]!! + index
                if (indexesSum < min) {
                    result.clear()
                    min = indexesSum
                    result.add(s)
                } else if (indexesSum == min) {
                    result.add(s)
                }
            }
        }
        return result.toTypedArray()
    }
}