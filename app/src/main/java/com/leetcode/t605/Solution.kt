package com.leetcode.t605

class Solution {
    fun canPlaceFlowers(flowerbed: IntArray, n: Int): Boolean {
        if (n == 0) return true
        var count = 0

        for (i in 0..flowerbed.lastIndex) {
            val isLeftPotEmpty = i - 1 < 0 || flowerbed[i - 1] == 0
            val isRightPotEmpty = i + 1 > flowerbed.lastIndex || flowerbed[i + 1] == 0

            if (flowerbed[i] == 0 && isLeftPotEmpty && isRightPotEmpty) {
                flowerbed[i] = 1
                count++
                if (count == n) {
                    return true
                }
            }
        }

        return false
    }
}