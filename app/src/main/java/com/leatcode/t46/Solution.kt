package com.leatcode.t46

import com.leatcode.util.print
import java.util.LinkedList
import java.util.Queue

fun main() {
    Solution().permute(intArrayOf(1, 2, 3)).forEach {
        it.print()
    }
}

class Solution {

    fun permute_bits(nums: IntArray): List<List<Int>> = mutableListOf<List<Int>>().apply {
        val curr = mutableListOf<Int>()
        fun dfs(mask: Int) {
            if (curr.size == nums.size) {
                this += curr.toList()
            } else {
                nums.forEachIndexed { i, n ->
                    if (mask and (1 shl i) == 0) {
                        curr += n
                        dfs(mask or (1 shl i))
                        curr.removeAt(curr.lastIndex)
                    }
                }
            }
        }
        dfs(0)
    }

    fun permute(nums: IntArray): List<List<Int>> = mutableListOf<List<Int>>().apply {

        val curr = mutableListOf<Int>()

        fun backtrack() {
            if (curr.size == nums.size) {
                this += curr.toList()
                return
            }

            for (n in nums) {
                if (curr.contains(n)) continue
                curr.add(n)
                backtrack()
                curr.removeLast()
            }
        }

        backtrack()
    }

    fun permute_Set(nums: IntArray): List<List<Int>> {
        val result = mutableListOf<List<Int>>()

        fun backtrack(curr: MutableList<Int>, nums: Queue<Int>) {
            if (nums.isEmpty()) {
                result.add(curr.toList())
                return
            }

            repeat(nums.size) {
                val n = nums.poll()!!
                curr.add(n)
                backtrack(curr, nums)
                curr.removeAt(curr.lastIndex)
                nums.add(n)
            }
        }

        backtrack(mutableListOf(), LinkedList<Int>().apply { nums.forEach { add(it) } })
        return result
    }
}