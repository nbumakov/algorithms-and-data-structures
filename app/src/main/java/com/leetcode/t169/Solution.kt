package com.leetcode.t169

import kotlin.random.Random

class Solution {

    // Approach 7: Boyer-Moore Voting Algorithm
    fun majorityElement7(nums: IntArray): Int {
        var candidate: Int = nums.first()
        var count = 0
        nums.forEach {
            if (count == 0) {
                candidate = it
            }
            count += if (it == candidate) 1 else -1
        }
        return candidate
    }

    // Approach 7: Boyer-Moore Voting Algorithm
    fun majorityElement7_2(nums: IntArray): Int =
        nums.fold(nums.first() to 0) { (candidate, count), n ->
            val newCandidate = if (count == 0) n else candidate
            val newCount = count + if (newCandidate == n) 1 else -1
            newCandidate to newCount
        }.first

    // Approach 5: Randomization
    fun majorityElement(nums: IntArray): Int {
        while (true) {
            val i = Random.nextInt(nums.size)
            val n = nums[i]
            val count = nums.count { it == n }
            if (count > nums.size / 2) return n
        }
    }

    fun majorityElement2(nums: IntArray): Int =
        nums.groupBy { it }
            .filter { it.value.size > nums.size / 2 }
            .map { it.value }
            .first()
            .first()
}