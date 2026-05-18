package com.leatcode.t1356

class Solution {

    fun sortByBits(arr: IntArray): IntArray =
        arr.sortedWith(compareBy({ it.countOneBits() }, { it }))
            .toIntArray()

    fun sortByBits1(arr: IntArray): IntArray =
        arr.sortedWith { o1, o2 ->
            val o1Bits = o1.countOneBits()
            val o2Bits = o2.countOneBits()

            if (o1Bits != o2Bits) o1Bits - o2Bits else o1 - o2
        }.toIntArray()

    fun sortByBits2(arr: IntArray): IntArray {
        fun Int.weight(): Int {
            var x = this
            var weight = 0
            while (x != 0) {
                if (x and 1 == 1) weight++
                x = x shr 1
            }
            return weight
        }

        return arr.sortedWith { o1, o2 ->
            val o1Bits = o1.weight()
            val o2Bits = o2.weight()

            if (o1Bits != o2Bits) o1Bits - o2Bits else o1 - o2
        }.toIntArray()
    }
}