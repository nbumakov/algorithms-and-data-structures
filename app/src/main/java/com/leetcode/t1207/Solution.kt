package com.leetcode.t1207

class Solution {
    fun uniqueOccurrences(arr: IntArray): Boolean {
        val occurrences = hashMapOf<Int, Int>()
        arr.forEach { occurrences[it] = occurrences.getOrDefault(it, 0) + 1 }
        val set = hashSetOf<Int>()
        occurrences.values.forEach {
            if (set.contains(it)) return false
            set.add(it)
        }
        return true
    }
}