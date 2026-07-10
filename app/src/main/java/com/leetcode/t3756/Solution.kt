package com.leetcode.t3756

class Solution {
    // For query [l, r]: drop the zero digits from s[l..r], read what's left as a
    // decimal number X, sum its digits as S, and return (X * S) mod 1e9+7.
    // Precompute prefix value/sum/count over the non-zero digits so each query is O(1).
    fun sumAndMultiply(s: String, queries: Array<IntArray>): IntArray {
        val MOD = 1_000_000_007L
        val n = s.length

        val prefixValue = LongArray(n + 1) // decimal value (mod MOD) of non-zero digits in s[0, i)
        val prefixSum = LongArray(n + 1)   // sum of non-zero digits in s[0, i)
        val prefixCount = IntArray(n + 1)  // count of non-zero digits in s[0, i)
        val powerOfTen = LongArray(n + 1)  // 10^i mod MOD

        powerOfTen[0] = 1
        for (i in 1..n) {
            val digit = s[i - 1] - '0'
            if (digit == 0) {
                prefixValue[i] = prefixValue[i - 1]
                prefixSum[i] = prefixSum[i - 1]
                prefixCount[i] = prefixCount[i - 1]
            } else {
                prefixValue[i] = (prefixValue[i - 1] * 10 + digit) % MOD
                prefixSum[i] = prefixSum[i - 1] + digit
                prefixCount[i] = prefixCount[i - 1] + 1
            }
            powerOfTen[i] = (powerOfTen[i - 1] * 10) % MOD
        }

        return IntArray(queries.size) { idx ->
            val (from, to) = queries[idx]
            val left = from    // prefix index just before the range starts
            val right = to + 1 // prefix index just after the range ends

            val nonZeroCount = prefixCount[right] - prefixCount[left]
            val digitSum = prefixSum[right] - prefixSum[left]

            // prefixValue[left] occupies the top `nonZeroCount` digits of prefixValue[right];
            // shift it into place (multiply by 10^nonZeroCount) before subtracting it out.
            val rangeValue = ((prefixValue[right] - prefixValue[left] * powerOfTen[nonZeroCount]) % MOD + MOD) % MOD

            ((rangeValue * digitSum) % MOD).toInt()
        }
    }
}
