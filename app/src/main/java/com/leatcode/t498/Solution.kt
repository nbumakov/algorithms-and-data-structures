package com.leatcode.t498

import com.leatcode.util.print

fun main() {
    Solution().findDiagonalOrder(
        arrayOf(
            intArrayOf(1, 2, 3),
            intArrayOf(4, 5, 6),
            intArrayOf(7, 8, 9),
        )
    ).print()
}

class Solution {
    //[[1,2,3],[4,5,6],[7,8,9]]
    fun findDiagonalOrder(mat: Array<IntArray>): IntArray {
        val n = mat.size
        val m = mat.first().size

        var i = 0
        var j = 0
        var isUp = true
        val result = IntArray(n * m)
        var index = 0
        do {
            result[index++] = mat[i][j]
            if (isUp) {
                when {
                    i - 1 >= 0 && j + 1 < m -> {
                        i--
                        j++
                    }
                    j + 1 < m -> {
                        j++
                        isUp = false
                    }
                    else -> {
                        i++
                        isUp = false
                    }
                }
            } else {
                when {
                    j - 1 >= 0 && i + 1 < n -> {
                        i++
                        j--
                    }
                    i + 1 < n -> {
                        i++
                        isUp = true
                    }
                    else -> {
                        j++
                        isUp = true
                    }
                }
            }
        } while (i != n && j != m)
        return result
    }
}