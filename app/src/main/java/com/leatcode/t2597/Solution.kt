package com.leatcode.t2597

import com.leatcode.util.print
import kotlin.math.sign

fun main() {
    SolutionSD()
        .beautifulSubsets(intArrayOf(2, 4, 6), 2)
        .print()
}

class Solution {
    fun beautifulSubsets(nums: IntArray, k: Int): Int {
        nums.sort()
        val curr = mutableListOf<Int>()
        val subsets = mutableListOf<List<Int>>()
        fun backtrack(i: Int) {
            for (j in i..nums.lastIndex) {
                if (!curr.contains(nums[j] - k)) {
                    curr += nums[j]
                    subsets.add(curr.toList())
                    backtrack(j + 1)
                    curr.removeLast()
                }
            }
        }
        backtrack(0)
        return subsets.size
    }
}

class SolutionSD {
//    fun beautifulSubsets(nums: IntArray, k: Int): Int {
//        val curr = mutableListOf<Int>(); nums.sort()
//        fun dfs(i: Int): Int {
//            if (i >= nums.size) return if (curr.isEmpty()) 0 else 1
//            return if ((nums[i] - k) in curr) {
//                0
//            } else {
//                curr += nums[i]
//                dfs(i + 1)
//                curr.removeLast()
//            } + dfs(i + 1)
//        }
//        return dfs(0)
//    }

    fun beautifulSubsets(nums: IntArray, k: Int): Int {
        val curr = mutableListOf<Int>()
        nums.sort()

        fun dfs(i: Int): Int {
            if (i >= nums.size) return if (curr.isEmpty()) 0 else 1
            if (curr.contains(nums[i] - k)) return dfs(i + 1)

            curr += nums[i]
            val withoutSkip = dfs(i + 1)
            curr.removeLast()
            val withSkip = dfs(i + 1)

            return withoutSkip + withSkip
        }
        return dfs(0)
    }
}