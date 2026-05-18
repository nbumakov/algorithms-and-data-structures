package com.leetcode.t1095

interface MountainArray {
    fun get(index: Int): Int
    fun length(): Int
}

class Solution {

    // 1, 2, 3, 4, 5, 3, 1   target = 3
    fun findInMountainArray(target: Int, mountainArr: MountainArray): Int {

        var l = 0
        var r = mountainArr.length() - 1

        var max = Int.MIN_VALUE
        var indexOfMax = 0

        while (l < r) {
            val mid = (l + r) / 2
            val curr = mountainArr.get(mid)
            val prev = mountainArr.get(mid - 1)

            when {
                prev < curr -> l = mid + 1
                else -> r = mid - 1
            }

            if (curr > max) {
                max = curr
                indexOfMax = mid
            }
        }

        TODO()

//        while (l < r) { //
//            val mid = (l + r) / 2
//            val curr = mountainArr.get(mid)
//            val prev = mountainArr.get(mid - 1)
//
//            when {
//                target == curr -> return mid
//                prev < curr && target > curr -> r = mid - 1
//                prev > curr && target < curr -> l = mid + 1
//            }
//        }

    }
}