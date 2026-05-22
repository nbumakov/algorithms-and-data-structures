package com.leetcode.t33

import com.leetcode.util.print

fun main() {
    val nums = intArrayOf(4, 5, 6, 7, 0, 1, 2)
    val target = 3
    Solution1().search(nums, target).print()
    Solution2().search(nums, target).print()
}

// One-pass BS: determines which half is sorted and if target lies within it.
class Solution1 {
    fun search(nums: IntArray, target: Int): Int {
        var l = 0
        var r = nums.lastIndex

        while (l <= r) {
            val mid = (l + r) / 2

            when {
                target == nums[mid] -> return mid
                nums[l] <= nums[mid] -> {
                    if (target in nums[l] until nums[mid]) {
                        r = mid - 1
                    } else {
                        l = mid + 1
                    }
                }

                else -> {
                    if (target in nums[mid + 1]..nums[r]) {
                        l = mid + 1
                    } else {
                        r = mid - 1
                    }
                }
            }
        }
        return -1
    }
}

// Two-pass BS: finds the pivot point first, then performs BS in the correct sorted half.
class Solution2 {
    fun search(nums: IntArray, target: Int): Int {
        var l = 0
        var r = nums.lastIndex
        while (l <= r) {
            val mid = (l + r) / 2
            when {
                nums[mid] > nums.last() -> l = mid + 1
                else -> r = mid - 1
            }
        }
        val pivot = l
        if (target in nums[pivot]..nums.last()) {
            l = pivot
            r = nums.lastIndex
        } else {
            l = 0
            r = pivot
        }

        while (l <= r) {
            val mid = (l + r) / 2
            when {
                target < nums[mid] -> r = mid - 1
                target > nums[mid] -> l = mid + 1
                else -> return mid
            }
        }
        return -1
    }
}
