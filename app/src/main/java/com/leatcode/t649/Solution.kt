package com.leatcode.t649

import com.leatcode.util.print

fun main() {
    Solution().predictPartyVictory("RDD").print()
}

class Solution {
    fun predictPartyVictory(senate: String): String {
        var currSenate: CharSequence = senate
        val curr = StringBuilder()
        while (!currSenate.all { it == 'R' } && !currSenate.all { it == 'D' }) {
            var r = 0
            var d = 0
            currSenate.forEach {
                when (it) {
                    'R' -> if (d > 0) d-- else {
                        r++
                        curr.append('R')
                    }

                    'D' -> if (r > 0) r-- else {
                        d++
                        curr.append('D')
                    }
                }
            }
            currSenate = curr.filter {
                when (it) {
                    'R' -> --d < 0
                    'D' -> --r < 0
                    else -> true
                }
            }
            curr.clear()
        }
        return if (currSenate.first() == 'R') "Radiant" else "Dire"
    }
}