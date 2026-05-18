package com.leatcode.t18

import com.leatcode.util.print

fun main() {
    Solution().fourSum(intArrayOf(-3, -2, -1, 0, 0, 1, 2, 3), 0).print()
//    Solution().fourSum(intArrayOf(1000000000, 1000000000, 1000000000, 1000000000), -294967296).print()
}

class Solution {

    // hasSet approach n3, kSum
    fun fourSum(nums: IntArray, target: Int): List<List<Int>> {
        val result = hashSetOf<List<Int>>()
        fun twoSum(i: Int, candidates: List<Int>) {
            val set = hashSetOf<Long>()
            val candidatesSum = candidates.sum()
            for (k in i..nums.lastIndex) {
                val left = (target.toLong() - candidatesSum - nums[k])
                if (set.contains(left)) result.add((candidates + left.toInt() + nums[k]).sorted())
                set.add(nums[k].toLong())
            }
        }

        fun kSum(k: Int, i: Int, candidates: List<Int>) {
            if (k == 2) {
                twoSum(i, candidates)
                return
            }
            for (j in i..nums.lastIndex) {
                kSum(k - 1, j + 1, candidates + nums[j])
            }
        }

        kSum(4, 0, emptyList())

        return result.toList()
    }

    // two pointers approach, n3
    fun fourSum1(nums: IntArray, target: Int): List<List<Int>> {
        nums.sort()
        val result = hashSetOf<List<Int>>()
        for (i in 0..nums.lastIndex) {
            for (j in i + 1..nums.lastIndex) {
                var l = j + 1
                var r = nums.lastIndex
                while (l < r) {
                    val sum: Long = nums[i].toLong() + nums[j] + nums[l] + nums[r]
                    when {
                        sum < target -> l++
                        sum > target -> r--
                        else -> result.add(listOf(nums[i], nums[j], nums[l++], nums[r]))
                    }
                }
            }
        }
        return result.toList()
    }
}