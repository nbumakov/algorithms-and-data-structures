package com.leatcode.t657

class Solution {
    fun judgeCircle(moves: String): Boolean =
        moves.count { it == 'L' } ==  moves.count { it == 'R' }
                && moves.count { it == 'U' } ==  moves.count { it == 'D' }
}