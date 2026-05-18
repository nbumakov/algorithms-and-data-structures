package com.leetcode.t2657

class Solution {
    fun findThePrefixCommonArray(A: IntArray, B: IntArray): IntArray {
        val C = IntArray(A.size)
        val set = hashSetOf<Int>()
        var count = 0
        for (i in A.indices) {
            if (!set.add(A[i])) count++
            if (!set.add(B[i])) count++
            C[i] = count
        }
        return C
    }
}