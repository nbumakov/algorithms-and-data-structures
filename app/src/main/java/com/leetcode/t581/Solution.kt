package com.leetcode.t581

import kotlin.math.max
import kotlin.math.min

class Solution {

    // Approach 3: Using Sorting nlogn
    fun findUnsortedSubarray(nums: IntArray): Int {
        val sorted = nums.sorted()
        var start = -1
        for (i in nums.indices) {
            if (nums[i] != sorted[i]) {
                start = i
                break
            }
        }
        if (start == -1) return 0

        var end = -1
        for (i in nums.lastIndex downTo 0) {
            if (nums[i] != sorted[i]) {
                end = i
                break
            }
        }
        return end - start + 1
    }

    //Approach 4: Using Stack
    fun findUnsortedSubarray4(nums: IntArray): Int {
        val stack = ArrayDeque<Int>()

        var start = nums.lastIndex
        for (i in nums.indices) {
            while (stack.isNotEmpty() && stack.last() > nums[i]) {
                stack.removeLast()
                start = min(start, stack.size)
            }
            stack.add(nums[i])
        }

        if (start == nums.lastIndex) return 0

        stack.clear()
        var end = 0
        for (i in nums.lastIndex downTo 0) {
            while (stack.isNotEmpty() && stack.last() < nums[i]) {
                stack.removeLast()
                end = max(end, nums.lastIndex - stack.size)
            }
            stack.add(nums[i])
        }

        return end - start + 1
    }

    //Approach 5: Without Using Extra Space
    fun findUnsortedSubarray5(nums: IntArray): Int {
        var min = Int.MAX_VALUE
        var max = Int.MIN_VALUE

        var flag = false
        for (i in 1..nums.lastIndex) {
            if (nums[i] < nums[i - 1]) flag = true
            if (flag) min = min(min, nums[i])
        }
        flag = false
        for (i in nums.lastIndex - 1 downTo 0) {
            if (nums[i] > nums[i + 1]) flag = true
            if (flag) max = max(max, nums[i])
        }
        var start = nums.size
        for (l in 0..nums.lastIndex) {
            if (min < nums[l]) {
                start = l
                break
            }
        }
        if (start == nums.size) return 0

        var end = 0
        for (r in nums.lastIndex downTo 0) {
            if (max > nums[r]) {
                end = r
                break
            }
        }

        return end - start + 1
    }
}