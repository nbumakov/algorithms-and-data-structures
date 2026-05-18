package com.leatcode.t1846

import com.leatcode.util.print
import kotlin.math.min

fun main() {
    Solution().maximumElementAfterDecrementingAndRearranging(intArrayOf(1, 2, 2, 2, 1)).print()
}

class Solution {

    fun maximumElementAfterDecrementingAndRearranging(arr: IntArray): Int {
        val counts = IntArray(arr.size + 1)
        for (n in arr) counts[min(n, arr.size)]++
        return (2..arr.size).fold(1) { acc, n -> min(acc + counts[n], n) }
    }

    fun maximumElementAfterDecrementingAndRearrangingSlow(arr: IntArray): Int {
        arr.sort()
        arr[0] = 1
        for (i in 1..arr.lastIndex) {
            if (arr[i] > arr[i - 1] + 1) arr[i] = arr[i - 1] + 1
        }
        return arr.max()
    }
}