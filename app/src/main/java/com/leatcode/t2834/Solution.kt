package com.leatcode.t2834

class Solution {
    fun minimumPossibleSum(n: Int, target: Int): Long {
        val set = hashSetOf<Long>()
        var curr = 0L
        while (set.size < n) {
            curr++
            if (set.contains(target - curr)) {
                continue
            }
            set.add(curr)
        }
        return set.sum()
    }
}