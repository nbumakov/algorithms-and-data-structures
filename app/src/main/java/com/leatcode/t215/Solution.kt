package com.leatcode.t215

import com.leatcode.util.print
import java.util.PriorityQueue
import kotlin.random.Random

fun main() {
    Solution().findKthLargest(intArrayOf(3, 2, 3, 1, 2, 4, 5, 5, 6), 4).print()
}


// with heap (nlog(k)
class Solution {
    fun findKthLargest(nums: IntArray, k: Int): Int = with(PriorityQueue<Int>()) {
        nums.forEach { add(it); if (size > k) remove() }
        peek()!!
    }
}

// QuickSelect  O(n?), worst case O(n^2)
class Solution2 {

    fun findKthLargest(nums: IntArray, k: Int): Int {
        fun quickSelect(nums: List<Int>, k: Int): Int {
            val pivot = nums[Random.nextInt(nums.size)]

            val left = nums.filter { it > pivot }
            val mid = nums.filter { it == pivot }
            val right = nums.filter { it < pivot }

            return when {
                k <= left.size -> quickSelect(left, k)
                left.size + mid.size < k -> quickSelect(right, k - left.size - mid.size)
                else -> pivot
            }
        }

        return quickSelect(nums.toList(), k)
    }

}

// Approach 4: Counting Sort - O(n+m) where m is maxValue - minValue
class Solution3 {
    fun findKthLargest(nums: IntArray, k: Int): Int {
        val max = nums.max()
        val min = nums.min()

        val count = IntArray(max - min + 1)

        nums.forEach { count[it - min]++ }

        var remains = k
        for (i in count.size - 1 downTo 0) {
            remains -= count[i]
            if (remains <= 0) return i + min
        }

        return -1
    }
}