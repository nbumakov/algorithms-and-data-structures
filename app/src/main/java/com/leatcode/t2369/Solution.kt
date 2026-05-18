package com.leatcode.t2369

import com.leatcode.util.print

fun main() {
//    Solution().validPartition(intArrayOf(4, 4, 4, 5, 6)).print()
//    Solution().validPartition(intArrayOf(1, 1, 1, 2)).print()
    Solution().validPartition(intArrayOf(1, 1, 1, 3, 3, 5, 5, 5, 9, 9, 9)).print()
}

class Solution {
    fun validPartition(nums: IntArray): Boolean {
        val visited = hashSetOf<Int>()

        fun dfs(i: Int): Boolean {
            if (i == nums.size) return true
            if (visited.contains(i)) return false

            val left = nums.size - i

            if (left >= 3
                && ((i until i + 3).run { nums.equal(this) || nums.increasing(this) })
                && dfs(i + 3)
            ) return true

            if (left >= 2
                && nums.equal(i until i + 2)
                && dfs(i + 2)
            ) return true

            visited.add(i)

            return false
        }

        return dfs(0)
    }

    private fun IntArray.equal(intRange: IntRange): Boolean {
        val first = this[intRange.first]
        for (i in intRange) {
            if (this[i] != first) return false
        }
        return true
    }

    private fun IntArray.increasing(intRange: IntRange): Boolean {
        var cur = this[intRange.first] - 1
        for (i in intRange) {
            if (this[i] != cur + 1) {
                return false
            }
            cur = this[i]
        }
        return true
    }
}