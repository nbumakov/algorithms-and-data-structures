package com.leatcode.t1550

class Solution {
    fun threeConsecutiveOdds(arr: IntArray): Boolean = arr
        .asSequence()
        .windowed(3)
        .any { window -> window.all { it % 2 == 1 } }
}

class Solution2 {
    fun threeConsecutiveOdds(arr: IntArray): Boolean {
        var counter = 0
        for (n in arr){
            if (n % 2 == 0) counter = 0 else counter++
            if (counter == 3) return true
        }
        return false
    }
}

class Solution3 {
    fun threeConsecutiveOdds(arr: IntArray): Boolean {
        var counter = 0
        for (n in arr){
            if (n and 1 == 0) counter = 0 else counter++
            if (counter == 3) return true
        }
        return false
    }
}