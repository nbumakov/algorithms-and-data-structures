package com.leetcode.t969

class Solution {
    fun pancakeSort(arr: IntArray): List<Int> {
        val result = mutableListOf<Int>()

        fun flip(i: Int) {
            result.add(i + 1)
            for (j in 0..i / 2) {
                val temp = arr[j]
                arr[j] = arr[i - j]
                arr[i - j] = temp
            }
        }

        for (i in arr.lastIndex downTo 1){
            if (arr[i] != i + 1) {
                val index = arr.indexOf(i + 1)
                flip(index)
                flip(i)
            }
        }

        return result
    }
}