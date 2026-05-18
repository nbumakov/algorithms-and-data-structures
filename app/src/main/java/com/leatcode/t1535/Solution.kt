package com.leatcode.t1535

import com.leatcode.util.print


fun main() {
    Solution().getWinner(intArrayOf(2,1,3,5,4,6,7), 1_000_000_000).print()
    Solution().getWinnerSD(intArrayOf(2,1,3,5,4,6,7), 1_000_000_000).print()
}

class Solution {
    fun getWinner(arr: IntArray, k: Int): Int {
        if (k > arr.size) return arr.max()

        var count = 0
        val ad = ArrayDeque<Int>().apply { addAll(arr.toList()) }

        while (count < k) {
            val first = ad.removeFirst()
            val second = ad.removeFirst()

            if (first > second) {
                count++
                ad.addFirst(first)
                ad.addLast(second)
            } else {
                count = 1
                ad.addFirst(second)
                ad.addLast(first)
            }
        }

        return ad.first()
    }

    fun getWinner2(arr: IntArray, k: Int): Int {
        var wins = 0
        var max = arr[0]
        for (i in 1..arr.lastIndex) {
            if (arr[i] > max) {
                wins = 1
                max = arr[i]
            } else {
                wins++
            }
            if (wins == k) break
        }
        return max
    }

    fun getWinnerSD(arr: IntArray, k: Int): Int {
        var wins = -1
        var max = arr[0]
        for (x in arr) {
            if (x > max) {
                wins = 1
                max = x
            } else wins++
            if (wins == k) break
        }
        return max
    }
}