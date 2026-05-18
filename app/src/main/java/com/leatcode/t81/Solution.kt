package com.leatcode.t81

import com.leatcode.util.print

fun main() {

    Solution()
        .search(intArrayOf(1, 1, 1, 1, 1, 1, 1, 1, 1, 13, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1), 13)
        .print()

//    Solution()
//        .search(intArrayOf(2, 5, 6, 0, 0, 1, 2), 3)
//        .print()
//
//    Solution()
//        .search(intArrayOf(2, 5, 6, 0, 0, 1, 2), 0)
//        .print()
//
//    Solution()
//        .search(intArrayOf(4, 5, 6, 6, 7, 0, 1, 2, 4, 4, 4, 4, 4, 4, 4, 4), 7)
//        .print()
}

class Solution {

//    fun search(nums: IntArray, target: Int): Boolean =
//        nums.any { it == target }


    fun search(nums: IntArray, target: Int): Boolean {
        var l = 0
        var r = nums.lastIndex

        //[4,5,6,6,7,0,1,2,4,4,4,4,4,4,4,4]
        while (l <= r) {
            val mid = (l + r) / 2
            when {
                target == nums[mid] -> return true

                nums[l] == nums[r] -> {
                    if (nums[l] == target) {
                        return true
                    } else {
                        l++
                        r--
                    }
                }

                nums[l] <= nums[mid] -> {
                    if (target in nums[l]..nums[mid]) {
                        r = mid - 1
                    } else {
                        l = mid + 1
                    }
                }

                else -> {
                    if (target in nums[mid]..nums[r]) {
                        l = mid + 1
                    } else {
                        r = mid - 1
                    }
                }

            }
        }
        return false
    }
}