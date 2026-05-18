package com.leatcode.t728

class Solution {
    fun selfDividingNumbers(left: Int, right: Int): List<Int> =
        (left..right).filter { it.isSelfDividing() }

    private fun Int.isSelfDividing(): Boolean =
        toString().all { it != '0' && this % it.digitToInt() == 0 }
}