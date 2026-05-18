package com.leatcode.t1636

class Solution {
    fun frequencySort(nums: IntArray): IntArray =
        nums.groupBy { it }
            .run { toSortedMap(compareBy({ this[it]!!.size }, { -it })) }
            .flatMap { (k, v) -> List(v.size) { k } }
            .toIntArray()
}

class Solution2 {
    fun frequencySort(nums: IntArray): IntArray {
        val count = IntArray(201)
        nums.forEach { count[it + 100]++ }
        val sortedCount = count.withIndex().sortedWith(compareBy({ it.value }, { -it.index }))
        return sortedCount.flatMap { (i, c) -> List(c) { i - 100 } }.toIntArray()
    }
}


//class Solution2 {
//    fun frequencySort(nums: IntArray): IntArray {
//        fun Int.digitAt(position: Int): Int {
//            var n = this
//            repeat(position) {
//                n /= 10
//            }
//            return n % 10
//        }
//
//        return nums
//            .map { it + 100 }
//            .sortedWith(
//                compareBy(
//                    { it.digitAt(3) },
//                    { it.digitAt(2) },
//                    { it.digitAt(1) },
//                )
//            ).map { it - 100 }
//            .toIntArray()
//    }
//
//}