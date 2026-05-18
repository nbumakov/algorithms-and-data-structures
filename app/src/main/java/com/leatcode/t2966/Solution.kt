package com.leatcode.t2966


class Solution {

    fun divideArray(nums: IntArray, k: Int) = nums
        .sorted().chunked(3).toTypedArray()
        .takeIf { chunk -> chunk.all { it.last() - it.first() <= k } } ?: arrayOf()

}