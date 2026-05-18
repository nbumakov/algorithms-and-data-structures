package com.leetcode.t161

class Solution {
    fun isOneEditDistance(s: String, t: String): Boolean = when {
        s.length == t.length + 1 -> isOneRemoveApart(s, t)
        t.length == s.length + 1 -> isOneRemoveApart(t, s)
        s.length == t.length -> isOneEditApart(s, t)
        else -> false
    }

    private fun isOneRemoveApart(s: String, t: String): Boolean {
        var skip = 0
        for (i in s.indices) {
            if (i - skip == t.length || s[i] != t[i - skip]) skip++
            if (skip > 1) break
        }
        return skip == 1
    }

    private fun isOneEditApart(s: String, t: String): Boolean {
        var diff = 0
        for (i in s.indices) {
            if (s[i] != t[i]) diff++
            if (diff > 1) break
        }
        return diff == 1
    }
}