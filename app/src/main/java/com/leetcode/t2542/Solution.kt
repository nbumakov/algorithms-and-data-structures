package com.leetcode.t2542

import com.leetcode.util.print
import java.util.PriorityQueue

fun main() {
    Solution().maxScore(intArrayOf(4, 2, 3, 1, 1), intArrayOf(7, 5, 10, 9, 6), 1).print()
}

class Solution {

    //TODO: solve it again by yourself
    fun maxScore(nums1: IntArray, nums2: IntArray, k: Int): Long {
        // Sort pair (nums1[i], nums2[i]) by nums2[i] in decreasing order.
        val n: Int = nums1.size
        val pairs = Array(n) { nums1[it] to nums2[it] }
        pairs.sortByDescending { it.second }

        // Use a min-heap to maintain the top k elements.
        val topKHeap = PriorityQueue<Int>()
        var topKSum: Long = 0
        for (i in 0 until k) {
            topKSum += pairs[i].first
            topKHeap.add(pairs[i].first)
        }

        // The score of the first k pairs.
        var answer = topKSum * pairs[k - 1].second

        // Iterate over every nums2[i] as minimum from nums2.
        for (i in k until n) {
            // Remove the smallest integer from the previous top k elements
            // then add nums1[i] to the top k elements.
            topKSum += (pairs[i].first - topKHeap.poll()!!).toLong()
            topKHeap.add(pairs[i].first)

            // Update answer as the maximum score.
            answer = maxOf(answer, topKSum * pairs[i].second)
        }

        return answer
    }
}