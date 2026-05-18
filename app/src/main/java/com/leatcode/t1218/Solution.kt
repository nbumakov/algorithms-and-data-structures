package com.leatcode.t1218

class Solution {
    // 1,5,7,8,5,3,4,2,1 , k= -2
    fun longestSubsequence(arr: IntArray, difference: Int): Int = with(hashMapOf<Int, Int>()) {
        for (n in arr) {
            this[n] = getOrDefault(n - difference, 0) + 1
        }
        return values.max()!!
    }
}