package com.leatcode.t2418

class Solution {
    fun sortPeople(names: Array<String>, heights: IntArray): Array<String> =
        names.zip(heights.toList())
            .sortedByDescending { it.second }
            .map { it.first }
            .toTypedArray()
}

class Solution2 {
    fun sortPeople(names: Array<String>, heights: IntArray): Array<String> =
        heights.withIndex()
            .sortedByDescending { it.value }
            .map { names[it.index] } as Array<String>
}

class Solution3 {
    fun sortPeople(names: Array<String>, heights: IntArray) =
        names.withIndex()
            .sortedByDescending { heights[it.index] }
            .map { names[it.index] }
}