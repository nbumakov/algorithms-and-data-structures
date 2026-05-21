package com.leetcode.t3043

import kotlin.math.log10

class Solution1 {
    fun longestCommonPrefix(arr1: IntArray, arr2: IntArray): Int {
        val arr1Prefixes = buildSet {
            arr1.forEach { addAll(it.generatePrefixes()) }
        }

        return arr2.maxOf { y ->
            y.generatePrefixes()
                .firstOrNull { prefix -> prefix in arr1Prefixes }
                ?.toString()
                ?.length ?: 0
        }
    }

    private fun Int.generatePrefixes() = buildList {
        var x = this@generatePrefixes
        while (x != 0) {
            add(x)
            x /= 10
        }
    }
}

class Solution2 {
    fun longestCommonPrefix(arr1: IntArray, arr2: IntArray): Int {
        val prefixes = HashSet<Int>(arr1.size * 8)
        for (num in arr1) {
            var n = num
            while (n > 0) {
                if (!prefixes.add(n)) break
                n /= 10
            }
        }

        var maxLen = 0
        for (num in arr2) {
            var n = num
            var currentLen = n.length
            if (currentLen <= maxLen) continue

            while (n > 0 && currentLen > maxLen) {
                if (n in prefixes) {
                    maxLen = currentLen
                    break
                }
                n /= 10
                currentLen--
            }
        }
        return maxLen
    }

    private val Int.length
        get(): Int {
            if (this == 0) return 1
            return log10(toDouble()).toInt() + 1
        }
}
