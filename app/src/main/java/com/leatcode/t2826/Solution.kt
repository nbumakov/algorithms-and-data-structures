package com.leatcode.t2826

import com.leatcode.util.print

fun main() {
    //Solution().minimumOperations(listOf(3, 3, 2)).print()
//    Solution().minimumOperations(listOf(2, 2, 1, 2)).print()
//    Solution().minimumOperations(listOf(2, 1, 3, 2, 1)).print()
//    Solution().minimumOperations(listOf(1, 3, 2, 1, 3, 3)).print()
//    Solution().minimumOperations(listOf(2, 2, 2, 2, 3, 3)).print()
    Solution().minimumOperations(listOf(3, 1, 2)).print()
}

class Solution {

    // Найти минимальное количество изменений, чтобы массив стал отсортированным
    // минимальное количество изменений = длина массива - длина наибольшей неубывающей последовательсности
    fun minimumOperations(nums: List<Int>): Int {
        val dp = IntArray(nums.size)
        dp[dp.lastIndex] = 1
        for (i in dp.lastIndex - 1 downTo 0) {
            var max = 0
            for (j in i + 1..dp.lastIndex) {
                if (nums[j] >= nums[i]) max = maxOf(max, dp[j])
            }
            dp[i] = max + 1
        }
        return nums.size - (dp.max() ?: 0)
    }

    // TLE - попытка перебора вариантов
    fun minimumOperations1(nums: List<Int>): Int {
        val numsArray = nums.toIntArray()
        if (isSorted(numsArray)) return 0

        var minCount = Int.MAX_VALUE
        fun backtrack(i: Int, count: Int) {
            if (i > numsArray.lastIndex) {
                if (isSorted(numsArray)) {
                    minCount = minOf(minCount, count)
                    return
                }
                return
            }

            for (j in 1..3) {
                val temp = numsArray[i]
                if (nums[i] == j) {
                    backtrack(i + 1, count)
                } else {
                    numsArray[i] = j
                    backtrack(i + 1, count + 1)
                }
                numsArray[i] = temp
            }
        }
        backtrack(0, 0)
        return minCount
    }

    private fun isSorted(a: IntArray): Boolean {
        for (i in 0 until a.size - 1) {
            if (a[i] > a[i + 1]) {
                return false
            }
        }
        return true
    }
}


