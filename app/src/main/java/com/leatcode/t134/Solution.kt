package com.leatcode.t134

import com.leatcode.util.print

// 3, 4, 5, 1, 2
// 1, 2, 3, 4, 5
//-2,-2,-2, 3, 3,   3,-2,-2,-2, 3

fun main() {
    Solution().canCompleteCircuit(intArrayOf(1, 2, 3, 4, 5), intArrayOf(3, 4, 5, 1, 2)).print()
    Solution().canCompleteCircuit(intArrayOf(2, 3, 4), intArrayOf(3, 4, 3)).print()
}

class Solution {

    fun canCompleteCircuit(gas: IntArray, cost: IntArray): Int {
        for (i in gas.indices) gas[i] -= cost[i]

        var sum = 0
        var currGas = 0
        var ans = 0

        for (i in gas.indices) {
            sum += gas[i]
            currGas += gas[i]
            if (currGas < 0) {
                currGas = 0
                ans = i + 1
            }
        }
        return if (sum < 0) -1 else ans
    }
}