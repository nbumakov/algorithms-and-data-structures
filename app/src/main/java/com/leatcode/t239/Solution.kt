package com.leatcode.t239

import com.leatcode.util.print
import java.util.PriorityQueue

fun main() {
    Solution().maxSlidingWindow(intArrayOf(1, 3, -1, -3, 5, 3, 6, 7), 3).print()
}

class Solution {

    // TODO: sliding window as monotonic dq
    fun maxSlidingWindow(nums: IntArray, k: Int) = with(ArrayDeque<Int>(k)) {
        IntArray(nums.size - k + 1).also { result ->
            nums.forEachIndexed { i, n ->
                while (isNotEmpty() && nums[last()] <= n) removeLast()
                add(i)
                if (first() == i - k) removeFirst()
                if (i >= k - 1) result[i - k + 1] = nums[first()]
            }
        }
    }

    // sliding window as sorted list
    fun maxSlidingWindow1(nums: IntArray, k: Int): IntArray {
        val window = ArrayList<Int>(k)
        for (i in 0 until k - 1) window.add(nums[i])
        val result = IntArray(nums.size - k + 1)
        window.sort()
        for (i in k - 1..nums.lastIndex) {
            var index = window.binarySearch(nums[i])
            if (index < 0) index = -index - 1
            window.add(index, nums[i])
            result[i - k + 1] = window.last()
            window.removeAt(window.binarySearch(nums[i - k + 1]))
        }
        return result
    }
}