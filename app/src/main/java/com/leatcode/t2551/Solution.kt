package com.leatcode.t2551

class Solution {
    fun putMarbles(weights: IntArray, k: Int): Long {
        val pairWeights = LongArray(weights.size - 1) {
            (weights[it] + weights[it + 1]).toLong()
        }.apply { sort() }
        return pairWeights.takeLast(k - 1).sum() - pairWeights.take(k - 1).sum()
    }
}