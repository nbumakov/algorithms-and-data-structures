package com.leetcode.t1460

/**
 *  Solution: two dictionaries to store the frequency of each element in the target and arr arrays.
 */
class Solution {
    fun canBeEqual(target: IntArray, arr: IntArray): Boolean {
        val targetFrequencyMap = target.groupBy { it }.map { it.key to it.value.size }.toMap()
        val arrFrequencyMap = arr.groupBy { it }.map { it.key to it.value.size }.toMap()

        return targetFrequencyMap == arrFrequencyMap
    }
}

/**
 *  Solution2: two dictionaries to store the frequency of each element in the target and arr arrays.
 */
class Solution2 {
    fun canBeEqual(target: IntArray, arr: IntArray): Boolean {
        val frequencyMap = mutableMapOf<Int, Int>()
        target.forEach { frequencyMap[it] = frequencyMap.getOrDefault(it, 0) + 1 }

        arr.forEach {
            frequencyMap[it] = frequencyMap.getOrDefault(it, 0) - 1
        }

        return frequencyMap.all { it.value == 0 }
    }
}