package com.leatcode.t1497

class Solution {
    fun canArrange(arr: IntArray, k: Int): Boolean {
        val map = arr.map { it % k }
            .groupingBy { it }
            .eachCount()
        return map.all { (key, value) ->
            when {
                key == 0 -> value % 2 == 0
                key * 2 == k -> value % 2 == 0
                else -> map[key] == map[k - key]
            }
        }
    }
}

class Solution2 {
    fun canArrange(arr: IntArray, k: Int): Boolean {
        val count = IntArray(k)
        arr.forEach { count[(it % k + k) % k]++ }
        return count[0] % 2 == 0 && (1 until k).all { count[it] == count[k - it] }
    }
}