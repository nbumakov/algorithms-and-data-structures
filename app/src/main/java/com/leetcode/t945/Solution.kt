package com.leetcode.t945

class Solution {

    // O(NlogN)
    fun minIncrementForUnique(nums: IntArray): Int {
        nums.sort()
        var result = 0
        for (i in 1..nums.lastIndex) {
            if (nums[i - 1] >= nums[i]) {
                result += nums[i - 1] - nums[i] + 1
                nums[i] = nums[i - 1] + 1
            }
        }

        return result
    }
}

class Solution2 {

    // O(N + max)
    fun minIncrementForUnique(nums: IntArray): Int {
        val freq = IntArray(nums.size + nums.max())
        nums.forEach { freq[it]++ }

        var increments = 0
        for (i in freq.indices){
            if (freq[i] <= 1) continue

            // Determine excess occurrences, carry them over to the next value,
            // ensure single occurrence for current value, and update minIncrements.
            val duplicates: Int = freq[i] - 1
            freq[i + 1] += duplicates
            freq[i] = 1
            increments += duplicates
        }

        return increments
    }
}