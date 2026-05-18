package com.leetcode.t228

fun main() {
    val ranges = Solution().summaryRanges(intArrayOf(0, 1, 2, 4, 5, 7))
    println(ranges.joinToString())
}

class Solution {
    fun summaryRanges(nums: IntArray): List<String> {
        val intervals = mutableListOf<IntArray>()

        nums.forEach { n ->
            if (intervals.isEmpty() || intervals.last()[1] != n - 1) {
                intervals.add(intArrayOf(n, n))
            } else {
                intervals.last()[1] = n
            }
        }

        return intervals.map { if (it[0] == it[1]) "${it[0]}" else "${it[0]}->${it[1]}" }
    }

    fun summaryRangesTest(nums: IntArray): List<String> =
        nums.fold(mutableListOf<Pair<Int, Int>>()) { acc, n ->
            if (acc.isEmpty() || acc.last().second + 1 < n) {
                acc.add(n to n)
            } else {
                acc[acc.size - 1] = acc.last().first to n
            }
            acc
        }.map { (a, b) -> if (a == b) "$a" else "$a->$b" }

    fun summaryRanges1(nums: IntArray): List<String> {
        if (nums.isEmpty()) {
            return emptyList()
        }
        val result = mutableListOf<String>()
        var a = nums[0]
        var b = nums[0]

        for (i in 1 until nums.size) {
            val n = nums[i]
            if (b == n - 1) {
                b = n
            } else {
                result.addRange(a, b)
                a = n
                b = n
            }
        }

        result.addRange(a, b)

        return result
    }

    private fun MutableList<String>.addRange(a: Int, b: Int) =
        add(if (a == b) "$a" else "$a->$b")
}




