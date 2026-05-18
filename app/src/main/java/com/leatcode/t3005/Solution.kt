package com.leatcode.t3005

class Solution {
    fun maxFrequencyElements(nums: IntArray): Int {
        val qtyMap = mutableMapOf<Int, Int>()
        var max = 0
        var totalFrequencies = 0

        nums.forEach { 
            qtyMap[it] = qtyMap.getOrDefault(it, 0) + 1
            val qty = qtyMap[it]!!

            when {
                qty > max -> {
                   totalFrequencies = qty
                   max = qty
                }
                qty == max -> {
                    totalFrequencies += qty
                }
            }
        }

        return totalFrequencies
    }
}