package com.leetcode.t1051

import com.leetcode.util.print

fun main() {
//    Solution().heightChecker(intArrayOf(1, 1, 4, 2, 1, 3)).print()
//    SolutionManualSort().heightChecker(intArrayOf(1, 1, 4, 2, 1, 3)).print()
//    SolutionManualSort().heightChecker(intArrayOf(1, 2, 3, 4, 5)).print()
    SolutionManualSort().heightChecker(intArrayOf(5,1,2,3,4)).print()
}

class Solution {

    fun heightChecker1(heights: IntArray): Int {
        val expected = heights.sortedArray()

        var count = 0

        for (i in heights.indices) {
            if (heights[i] != expected[i]) {
                count++
            }
        }
        return count
    }

    fun heightChecker2(heights: IntArray): Int =
        heights.zip(heights.sorted()) { a, b -> a == b }
            .count { !it }

    fun heightChecker3(heights: IntArray): Int = heights
        .sorted().withIndex()
        .count { (i, h) -> h != heights[i] }
}

class SolutionManualSort {
    fun heightChecker(heights: IntArray): Int {
        val originalIndexed = heights.toList().withIndex()
        heights.qSort()
        return originalIndexed
            .count { (i, h) -> heights[i] != h }
    }

    private fun IntArray.qSort(range: IntRange = indices) {
        if (range.last <= range.first) return
        val pivotIndex = range.first + (range.last - range.first) / 2
        val pivot = this[pivotIndex]

        var left = range.first
        var right = range.last

        while (left <= right) {
            while (this[left] < pivot) left++
            while (this[right] > pivot) right--

            if (left <= right) {
                val temp = this[left]
                this[left] = this[right]
                this[right] = temp
                left++
                right--
            }
        }

        if (range.first < right) qSort(range.first..right)
        if (left < range.last) qSort(left..range.last)
    }

    fun List<Int>.qSort(): List<Int> {
        if (size <= 1) return this

        val pivot = last()
        val left = filter { it < pivot }
        val middle = filter { it == pivot }
        val right = filter { it > pivot }
        return left.qSort() + middle + right.qSort()
    }
}

class SolutionCountSort {
    fun heightChecker(heights: IntArray): Int {
        val qty = IntArray(101)
        heights.forEach { qty[it]++ }

        var i = 0
        var result = 0
        for (h in 1..100) {
            val q = qty[h]
            for (j in i until i + q) {
                if (heights[j] != h) result++
            }
            i += q
        }
        return result
    }
}