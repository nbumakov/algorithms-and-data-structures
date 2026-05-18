package com.leatcode.t1310

fun main() {
    Solution().xorQueries(intArrayOf(1, 3, 4, 8), arrayOf(intArrayOf(0, 1), intArrayOf(1, 2), intArrayOf(0, 3), intArrayOf(3, 3)))
        .joinToString()
        .let(::println)
}

class Solution {
    fun xorQueries(arr: IntArray, queries: Array<IntArray>): IntArray {
        val prefixXorArray = IntArray(arr.size + 1)
        for (i in arr.indices) {
            prefixXorArray[i + 1] = prefixXorArray[i] xor arr[i]
        }
        return IntArray(queries.size) { i ->
            val a = queries[i][0]
            val b = queries[i][1]
            prefixXorArray[b + 1] xor prefixXorArray[a]
        }
    }
}