package com.leatcode.t303

class NumArray(nums: IntArray) {

    private val prefixes = IntArray(nums.size).apply {
        var s = 0
        nums.forEachIndexed { index, n -> s += n; this[index] = s }
    }

    fun sumRange(left: Int, right: Int): Int =
        prefixes[right] - prefixes.getOrElse(left - 1) { 0 }

}