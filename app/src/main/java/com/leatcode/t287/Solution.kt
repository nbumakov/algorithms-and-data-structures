package com.leatcode.t287

import com.leatcode.util.print

fun main() {
    Solution().findDuplicate(intArrayOf(1, 2, 3, 2)).print()
}

class Solution {

    //TODO: solve again
    fun findDuplicate(nums: IntArray): Int {
        var tortoise = nums[0]
        var hare = nums[0]

        do {
            tortoise = nums[tortoise]
            hare = nums[nums[hare]]
        } while (tortoise != hare)

        // Find the "entrance" to the cycle.
        tortoise = nums[0]

        while (tortoise != hare) {
            tortoise = nums[tortoise]
            hare = nums[hare]
        }

        return hare
    }
}