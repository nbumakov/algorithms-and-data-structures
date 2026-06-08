package com.leetcode.t2161

class Solution {
    fun pivotArray(nums: IntArray, pivot: Int): IntArray {
        val answer = IntArray(nums.size)
        var i = 0

        fun fill(predicate: (Int) -> Boolean) {
            for (n in nums) if (predicate(n)) answer[i++] = n
        }

        fill { it < pivot }
        fill { it == pivot }
        fill { it > pivot }

        return answer
    }
}


class Solution2 {
    fun pivotArray(nums: IntArray, pivot: Int): IntArray {
        val n = nums.size
        val answer = IntArray(n)
        var left = 0
        var right = n - 1
        for (k in 0 until n) {
            if (nums[k] < pivot) answer[left++] = nums[k]
            if (nums[n - 1 - k] > pivot) answer[right--] = nums[n - 1 - k]
        }
        while (left <= right) answer[left++] = pivot
        return answer
    }
}