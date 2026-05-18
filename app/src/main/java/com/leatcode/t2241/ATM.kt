package com.leatcode.t2241

class ATM() {
    private val banknotes = longArrayOf(0, 0, 0, 0, 0)
    private val denominations = longArrayOf(500, 200, 100, 50, 20)

    fun deposit(banknotesCount: IntArray) {
        for (i in banknotes.indices) {
            banknotes[i] += banknotesCount[banknotesCount.lastIndex - i].toLong()
        }
    }

    fun withdraw(amount: Int): IntArray {
        var remains: Long = amount.toLong()
        val withdraw = intArrayOf(0, 0, 0, 0, 0)
        banknotes.forEachIndexed { index, denominationCount ->
            val denomination = denominations[index]
            val count = (remains / denomination).coerceAtMost(denominationCount)
            withdraw[index] = count.toInt()
            remains -= denomination * count
        }
        return if (remains > 0) intArrayOf(-1) else {
            withdraw.forEachIndexed { index, denominationCount ->
                banknotes[index] = banknotes[index] - denominationCount
            }
            withdraw.reversedArray()
        }
    }

}
