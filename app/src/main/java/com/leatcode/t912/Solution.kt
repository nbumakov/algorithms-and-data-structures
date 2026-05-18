package com.leatcode.t912

import java.util.PriorityQueue

class Solution {

    fun sortArray(nums: IntArray): IntArray = nums.apply {
        shuffle()
        quickSort()
    }

    private fun IntArray.quickSort(low: Int = 0, high: Int = lastIndex) {
        if (low >= high) return

        val pivotIndex = partition(low, high)
        quickSort(low, pivotIndex - 1)
        quickSort(pivotIndex + 1, high)
    }

    private fun IntArray.partition(low: Int, high: Int): Int {
        val pivot = this[high]
        var p1 = low
        for (p2 in low until high) {
            if (this[p2] < pivot) swap(p1++, p2)
        }

        swap(p1, high)
        return p1
    }

    private fun IntArray.swap(i: Int, j: Int) {
        val temp = this[i]
        this[i] = this[j]
        this[j] = temp
    }

    // babble sort TLE
    fun sortArray3(nums: IntArray): IntArray {
        repeat(nums.size) {
            for (i in 0 until nums.lastIndex) {
                if (nums[i] > nums[i + 1]) {
                    val temp = nums[i]
                    nums[i] = nums[i + 1]
                    nums[i + 1] = temp
                }
            }
        }

        return nums
    }

    // heap sort
    fun sortArray2(nums: IntArray): IntArray {
        val heap = PriorityQueue<Int>().apply {
            addAll(nums.asSequence())
        }

        return IntArray(nums.size) { heap.poll()!! }
    }

    //merge sort
    fun sortArray_1(nums: IntArray): IntArray {
        if (nums.size <= 1) return nums

        val part1 = sortArray(nums.sliceArray(0 until nums.size / 2))
        val part2 = sortArray(nums.sliceArray(nums.size / 2 until nums.size))

        var p1 = 0
        var p2 = 0
        return IntArray(nums.size) {
            when {
                p1 == part1.size -> part2[p2++]
                p2 == part2.size -> part1[p1++]
                part1[p1] < part2[p2] -> part1[p1++]
                else -> part2[p2++]
            }
        }
    }
}