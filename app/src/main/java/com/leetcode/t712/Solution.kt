package com.leetcode.t712

import com.leetcode.util.print
import java.util.Collections

import java.util.PriorityQueue




fun main() {
    Solution().minimumDeleteSum("delete", "leet").print()
}

class Solution {

    //TODO
    fun minimumDeleteSum(s1: String, s2: String): Int {
        val maxHeap = PriorityQueue(Collections.reverseOrder<Int>())
        TODO("Dificul :(")
    }

//    private fun String.toQtyMap(): HashMap<Char, Int> = hashMapOf<Char, Int>().apply {
//        this@toQtyMap.forEach { this[it] = getOrDefault(it, 0) + 1 }
//    }

}