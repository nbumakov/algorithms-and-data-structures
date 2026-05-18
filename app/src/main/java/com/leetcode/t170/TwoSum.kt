package com.leetcode.t170

class TwoSum() {

    private val qtyMap = hashMapOf<Int, Int>()

    fun add(number: Int) {
        qtyMap[number] = qtyMap.getOrDefault(number, 0) + 1
    }

    fun find(value: Int): Boolean {
        for (e in qtyMap) {
            val v1 = e.key
            val v2 = value - v1
            val v2Qty = qtyMap[v2]
            if (v2Qty != null && (v1 != v2 || v2Qty > 1)) {
                return true
            }
        }
        return false
    }

}