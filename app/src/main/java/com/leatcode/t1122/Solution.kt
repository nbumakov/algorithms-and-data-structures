package com.leatcode.t1122

class Solution {
    fun relativeSortArray(arr1: IntArray, arr2: IntArray): IntArray =
        (arr2.flatMap { a2 -> arr1.filter { it == a2 } }
                + arr2.toSet().let { set -> arr1.filter { it !in set } }.sorted())
            .toIntArray()
}

class Solution2 {
    fun relativeSortArray(arr1: IntArray, arr2: IntArray): IntArray {
        val associatedArr2 = arr2.withIndex().associate { (i, v) -> v to i }
        return arr1.sortedWith(compareBy({ associatedArr2[it] ?: Int.MAX_VALUE }, { it }))
            .toIntArray()
    }
}