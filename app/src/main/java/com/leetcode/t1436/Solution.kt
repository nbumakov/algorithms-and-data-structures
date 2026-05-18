package com.leetcode.t1436

class Solution {
    fun destCity(paths: List<List<String>>): String {
        val startPoints = mutableSetOf<String>()
        val endPoints = mutableSetOf<String>()
        paths.forEach {
            startPoints.add(it[0])
            endPoints.add(it[1])
        }
        return endPoints.first { it !in startPoints }
    }
}