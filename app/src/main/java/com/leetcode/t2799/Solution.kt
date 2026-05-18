package com.leetcode.t2799


class Solution2 {
    fun countCompleteSubarrays(nums: IntArray): Int {
        val countMap = mutableMapOf<Int, Int>()
        nums.forEach {
            countMap[it] = countMap.getOrElse(it) { 0 } + 1
        }
        var completeSubarrays = 0
        val set = nums.toSet()

        for(i in nums.indices) {
            val currentSet = mutableSetOf<Int>()
            var  j = i
            while (j < nums.size && currentSet.size != set.size) {
                currentSet.add(nums[j])
                j++
            }
            if (currentSet.size == set.size) {
                completeSubarrays += nums.size - j + 1
            }
        }

        return completeSubarrays
    }
}

class Solution {
    fun countCompleteSubarrays(nums: IntArray): Int {
       val countMap = mutableMapOf<Int, Int>()
        nums.forEach {
            countMap[it] = countMap.getOrElse(it) { 0 } + 1
        }
        var completeSubarrays = 0

        val visited = mutableSetOf<Pair<Int, Int>>()

        fun checkCompleteSubarray(start: Int, end: Int) {
            if (end < start || visited.contains(start to end)) return

            val a = nums[start]
            val b = nums[end]

            if (countMap.getOrElse(a) { 0 } == 0 || countMap.getOrElse(b) { 0 } == 0) return
            visited += Pair(start, end)
            completeSubarrays++
            if(countMap[a]!! > 1) {
                countMap[a] = countMap[a]!! - 1
                checkCompleteSubarray(start + 1, end)
                countMap[a] = countMap[a]!! + 1
            }

            if(countMap[b]!! > 1) {
                countMap[b] = countMap[b]!! - 1
                checkCompleteSubarray(start, end - 1)
                countMap[b] = countMap[b]!! + 1
            }
        }

        checkCompleteSubarray(0, nums.lastIndex)

        return completeSubarrays
    }
}

object SolutionSD{
    fun countCompleteSubarrays(nums: IntArray): Int {
        val f = IntArray(2001); var j = 0; var u = 0
        for (x in nums) if (f[x] < 1) { u++; ++f[x] }
        return nums.sumOf { x ->
            if (f[x]++ < 2) u--
            while (u < 1) if (--f[nums[j++]] < 2) u++
            j
        }
    }
}