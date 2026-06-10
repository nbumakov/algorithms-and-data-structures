package com.leetcode.t3691

import java.util.PriorityQueue

class Solution {

    /**
     * Heap-based k-way merge:
     * For each left endpoint l, the subarray values max−min decrease as r shrinks
     * (the widest window [l..n−1] is the most valuable), so this is n sorted lists
     * from which you need the k largest. Push the head of every list ([l..n−1]) into a max-heap,
     * then k times pop the max and push back the next element of that same l ([l..r−1]);
     * the Sparse Table answers max−min for any range in O(1). Total O((n+k) log n).
     */
    fun maxTotalValue(nums: IntArray, k: Int): Long {
        val n = nums.size
        val st = SparseTable(nums)
        // (значение, l, r); сравнение по значению, max-heap
        val heap = PriorityQueue<LongArray>(compareByDescending { it[0] })

        // голова каждого списка: самый широкий подмассив [l, n-1]
        for (l in 0 until n) {
            heap.add(longArrayOf(st.query(l, n - 1).toLong(), l.toLong(), (n - 1).toLong()))
        }

        var sum = 0L
        repeat(k) {
            val (value, l, r) = heap.poll()
            sum += value
            if (r > l) {
                val nr = r - 1
                heap.add(longArrayOf(st.query(l.toInt(), nr.toInt()).toLong(), l, nr))
            }
        }
        return sum
    }

    private class SparseTable(nums: IntArray) {
        private val n = nums.size
        private val log = IntArray(n + 1)
        private val mx: Array<IntArray>
        private val mn: Array<IntArray>

        init {
            for (i in 2..n) log[i] = log[i / 2] + 1
            val k = log[n] + 1
            mx = Array(k) { IntArray(n) }
            mn = Array(k) { IntArray(n) }
            mx[0] = nums.copyOf(); mn[0] = nums.copyOf()
            for (j in 1 until k) {
                for (i in 0..n - (1 shl j)) {
                    mx[j][i] = maxOf(mx[j-1][i], mx[j-1][i + (1 shl (j-1))])
                    mn[j][i] = minOf(mn[j-1][i], mn[j-1][i + (1 shl (j-1))])
                }
            }
        }

        fun query(l: Int, r: Int): Int { // max - min на [l, r]
            val j = log[r - l + 1]
            val hi = maxOf(mx[j][l], mx[j][r - (1 shl j) + 1])
            val lo = minOf(mn[j][l], mn[j][r - (1 shl j) + 1])
            return hi - lo
        }
    }
}