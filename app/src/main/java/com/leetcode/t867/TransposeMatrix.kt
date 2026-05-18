package com.leetcode.t867

/**
 * Given a 2D integer array matrix, return the transpose of matrix.
 *
 * The transpose of a matrix is the matrix flipped over its main diagonal,
 * switching the matrix's row and column indices.
 *
 * Input: matrix = [[1,2,3],[4,5,6],[7,8,9]]
 * Output: [[1,4,7],[2,5,8],[3,6,9]]
 *
 * Input: matrix = [[1,2,3],[4,5,6]]
 * Output: [[1,4],[2,5],[3,6]]
 */
fun main() {
    val matrix = parseMatrixFromString(readln())
    println(Solution().transpose(matrix).asString())
}

class Solution {
    fun transpose(matrix: Array<IntArray>): Array<IntArray> =
        Array(matrix[0].size) { column ->
            IntArray(matrix.size) { row ->
                matrix[row][column]
            }
        }
}

private fun parseMatrixFromString(matrixString: String): Array<IntArray> {
    // Remove the outer brackets from the string
    val trimmedString = matrixString.trim('[', ']')

    // Split the string into rows
    val rowStrings = trimmedString.split("],[")

    // Create a 2D array with the dimensions of the matrix
    val numRows = rowStrings.size
    val numCols = rowStrings[0].split(",").size
    val matrix = Array(numRows) { IntArray(numCols) }

    // Iterate over the row strings and populate the matrix
    for (i in 0 until numRows) {
        val rowString = rowStrings[i]
        val colStrings = rowString.split(",")
        for (j in 0 until numCols) {
            matrix[i][j] = colStrings[j].toInt()
        }
    }

    return matrix
}

private fun Array<IntArray>.asString(): String = buildString {
    append('[')
    this@asString.forEachIndexed { index, array ->
        append(array.asString())
        if (index != this@asString.size - 1) {
            append(',')
        }
    }
    append(']')
}

private fun IntArray.asString(): String = buildString {
    append('[')
    this@asString.forEachIndexed { index, c ->
        append(c)
        if (index != this@asString.size - 1) {
            append(',')
        }
    }
    append(']')
}