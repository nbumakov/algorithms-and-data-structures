package com.leetcode.t683

import com.leetcode.util.print
import java.util.TreeSet

fun main() {
    Solution().kEmptySlots(intArrayOf(1, 3, 2), 1).print()
}

class Solution {

    // nlogn
    fun kEmptySlots(bulbs: IntArray, k: Int): Int {
        val treeSet = TreeSet<Int>()
        bulbs.forEachIndexed { day, bulb ->
            val floor = runCatching { treeSet.floor(bulb) }.getOrNull()
            if (floor != null && bulb - floor - 1 == k) return day + 1

            val ceiling = runCatching { treeSet.ceiling(bulb) }.getOrNull()
            if (ceiling != null && ceiling - bulb - 1 == k) return day + 1

            treeSet.add(bulb)
        }

        return -1
    }

    // n2 brut force
    fun kEmptySlots2(bulbs: IntArray, k: Int): Int {
        val bulbDay = IntArray(bulbs.size)
        bulbs.forEachIndexed { day, bulb ->
            bulbDay[bulb - 1] = day + 1
        }

        for (day in 2..bulbs.size) {
            var count = 0
            val start = bulbDay.indexOfFirst { it <= day }
            val end = bulbDay.indexOfLast { it <= day }
            for (i in start..end) {
                if (bulbDay[i] > day) {
                    count++
                } else {
                    if (count == k && i != start) return day
                    count = 0
                }
            }
        }
        return -1
    }
}