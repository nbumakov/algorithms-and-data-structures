package com.leatcode.t2073

import kotlin.math.min

class Solution {
    fun timeRequiredToBuy(tickets: IntArray, k: Int): Int =
        tickets.withIndex().sumOf { (i, count) ->
            min(count, tickets[k] + if (i <= k) 0 else -1)
        }
}