package com.leetcode.t2053

class Solution {
    fun kthDistinct(arr: Array<String>, k: Int): String {
        val qtyMap = mutableMapOf<String, Int>()
        arr.forEach { qtyMap[it] = qtyMap.getOrDefault(it, 0) + 1 }
        return arr.asSequence()
            .filter { qtyMap[it] == 1 }
            .drop(k - 1)
            .firstOrNull() ?: ""
    }
}

class Solution2 {
    fun kthDistinct(arr: Array<String>, k: Int): String {
        val stringsSet = mutableSetOf<String>()
        val duplicateStrings = mutableSetOf<String>()

        arr.forEach {
            if (stringsSet.contains(it)) {
                duplicateStrings += it
            } else {
                stringsSet += it
            }
        }

        val distinctStrings = stringsSet - duplicateStrings

        return arr.asSequence()
            .filter { it in distinctStrings }
            .drop(k - 1)
            .firstOrNull() ?: ""
    }
}