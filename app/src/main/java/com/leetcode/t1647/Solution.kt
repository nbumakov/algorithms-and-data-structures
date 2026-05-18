package com.leetcode.t1647

import com.leetcode.util.print

fun main() {
//    Solution().minDeletions("aab").print()
//    Solution().minDeletions("aaabbbcc").print()
//    Solution().minDeletions("ceabaacb").print()
    Solution().minDeletions("abcabc").print()
}

class Solution {

    // Approach 1: Decrement Each Duplicate Until it is Unique
    fun minDeletions(s: String): Int {
        val qtyMap = hashMapOf<Char, Int>()
        s.forEach { qtyMap[it] = qtyMap.getOrDefault(it, 0) + 1 }
        val invertedQtyMap = sortedMapOf<Int, MutableList<Char>>()
        qtyMap.forEach { (char, qty) ->
            invertedQtyMap.getOrPut(qty) { mutableListOf() }.add(char)
        }
        var count = 0
        while (invertedQtyMap.isNotEmpty()) {
            val qty = invertedQtyMap.lastKey()
            if (invertedQtyMap[qty]!!.size > 1) {
                val char = invertedQtyMap[qty]!!.removeLast()
                if (qty - 1 > 0) {
                    invertedQtyMap.getOrPut(qty - 1) { mutableListOf() }.add(char)
                }
                count++
            } else {
                invertedQtyMap.remove(qty)
            }
        }
        return count
    }
}