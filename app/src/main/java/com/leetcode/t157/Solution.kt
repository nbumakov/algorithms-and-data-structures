package com.leetcode.t157


fun main() {
    val n = 5
    val buffer = CharArray(8)
    Solution().read(buffer, n)
    println(buffer.joinToString())
}

/**
 * The read4 API is defined in the parent class Reader4.
 * fun read4(buf4:CharArray): Int {}
 */

abstract class Reader4 {

    private val file = "leetcode"
    var pointer = 0

    fun read4(buf4: CharArray): Int {
        val end = minOf(pointer + 4, file.length)
        var bufPointer = 0
        val count = end - pointer
        repeat(end - pointer) {
            buf4[bufPointer++] = file[pointer++]
        }
        return count
    }

    abstract fun read(buf: CharArray, n: Int): Int
}

class Solution : Reader4() {


//    //TODO
//    override fun read(buf: CharArray, n: Int): Int {
//        var copiedChars = 0
//        var readChars = 4
//        val buf4 = CharArray(4)
//        while (copiedChars < n && readChars == 4) {
//            readChars = read4(buf4)
//            for (i in 0 until readChars) {
//                if (copiedChars == n) return copiedChars
//                buf[copiedChars++] = buf4[i]
//            }
//        }
//        return copiedChars
//    }
    /**
     * @param buf Destination buffer
     * @param n Number of characters to read
     * @return The number of actual characters read
     */
    override fun read(buf: CharArray, n: Int): Int {
        var readChars = 0
        val buf4 = CharArray(4)
        while (readChars < n) {
            val read = read4(buf4)

            for (i in 0 until minOf(read, n - readChars))
                buf[readChars++] = buf4[i]

            if (read < 4) break
        }

        return readChars
    }
}