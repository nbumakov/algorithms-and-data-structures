package com.leatcode.t779

import com.leatcode.util.print

fun main() {
    Solution().kthGrammar(2, 2).print()
}

class Solution {
    // 0
    // 01
    // 0110
    // 01101001
    // 0110100110010110
    // 01101001100101101001011001101001
    // n, k are 1-=0-indexed
    fun kthGrammar(n: Int, k: Int): Int {
        if (n == 1) return 0

        return if ((kthGrammar(n - 1, (k + 1) / 2) == 0) xor (k % 2 == 0)) 0 else 1

//        return if (kthGrammar(n - 1, (k+1) / 2) == 0) {
//            if (k % 2 == 0) 1 else 0
//        } else {
//            if (k % 2 == 0) 0 else 1
//        }
    }

}

class SolutionSamoylenkoDmitry {
    fun kthGrammar(n: Int, k: Int): Int = if (n == 1) 0 else
        (if (kthGrammar(n - 1, (k + 1) / 2) == 0) k.inv() else k) and 1
}