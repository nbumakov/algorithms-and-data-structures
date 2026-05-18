package com.leatcode.t968

import kotlin.math.max
import kotlin.math.min

class Solution {
    fun intervalIntersection(firstList: Array<IntArray>, secondList: Array<IntArray>): Array<IntArray> {
        var p1 = 0
        var p2 = 0

        val result = mutableListOf<IntArray>()

        while (p1 < firstList.size && p2 < secondList.size) {
            // добавить пересечение
            // пропустить самый малый интервал
            val intersection = firstList[p1].intersection(secondList[p2])
            if (intersection != null) result += intersection
            if (firstList[p1][1] < secondList[p2][1]) p1++ else p2++
        }

        return result.toTypedArray()
    }

    private fun IntArray.intersection(a: IntArray): IntArray? {
        val start = max(this[0], a[0])
        val end = min(this[1], a[1])
        return if (start <= end) intArrayOf(start, end) else null
    }

}