package com.leetcode.t1346

import com.leetcode.util.print

fun main() {
    Solution().checkIfExist(intArrayOf(7, 1, 14, 11)).print()
}

class Solution {
    fun checkIfExist(arr: IntArray): Boolean = with(hashSetOf<Int>()) {
        for (n in arr) {
            if (contains(2 * n) || (n % 2 == 0 && contains(n / 2))) {
                return@with true
            } else {
                add(n)
            }
        }

        return@with false
    }
}