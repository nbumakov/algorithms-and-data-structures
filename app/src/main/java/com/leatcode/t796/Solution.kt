package com.leatcode.t796

/**
 * Approach 2: Concatenation Check
 */
class Solution {
    fun rotateString(s: String, goal: String): Boolean {
        if (s.length != goal.length) return false
        if (s.toSet() != goal.toSet()) return false

        return (s + s).contains(goal)
    }
}