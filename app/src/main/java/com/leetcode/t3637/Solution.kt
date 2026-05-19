package com.leetcode.t3637

fun main() {
    println(Solution().isTrionic(intArrayOf(1, 3, 5, 4, 2, 6)))
    println(Solution().isTrionic(intArrayOf(2,1,3)))
    println(Solution().isTrionic(intArrayOf(6,7,5,1)))
}

class Solution {
    fun isTrionic(nums: IntArray): Boolean {
        if (nums.size < 3 || nums[0] >= nums[1]) return false

        var directionChanges = 0
        var currentDirection = 1

        for (i in 0 until nums.size - 1) {
            val windowDirection = when {
                nums[i] < nums[i + 1] -> 1
                nums[i] > nums[i + 1] -> -1
                else -> return false
            }

            if (windowDirection != currentDirection) {
                directionChanges++
                currentDirection = windowDirection
                if (directionChanges > 2) return false
            }
        }
        return directionChanges == 2
    }
}

class Solution2 {
    fun isTrionic(nums: IntArray): Boolean {
        var i = 0
        fun move(check: (Int, Int) -> Boolean): Boolean {
            val start = i
            while (i < nums.size - 1 && check(nums[i], nums[i + 1])) i++
            return i > start
        }

        return move { a, b -> a < b } &&
               move { a, b -> a > b } &&
               move { a, b -> a < b } &&
               i == nums.size - 1
    }
}
