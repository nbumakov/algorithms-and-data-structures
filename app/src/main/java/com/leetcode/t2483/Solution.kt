package com.leetcode.t2483

class Solution {
    fun bestClosingTime(customers: String): Int {
        val ns = IntArray(customers.length)
        var count = 0
        customers.forEachIndexed { index, c ->
            if (c == 'N') count++
            ns[index] = count
        }
        count = 0
        val ys = IntArray(customers.length)
        for (i in customers.lastIndex downTo 0) {
            if (customers[i] == 'Y') count++
            ys[i] = count
        }

        var min = Int.MAX_VALUE
        var minIndex = 0
        for (i in 0..customers.length) {
            val fine = ys.getOrElse(i) { 0 } + ns.getOrElse(i - 1) { 0 }
            if (fine < min){
                min = fine
                minIndex = i
            }
        }

        return minIndex
    }
}