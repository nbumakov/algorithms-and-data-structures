package com.leetcode.t3084

// Count substrings starting and ending with c. All pairs of positions (i, j) where s[i]==s[j]==c
// form valid substrings (including i==j for single-char). Total = C(count, 2) + count = count*(count+1)/2.
class Solution {
    fun countSubstrings(s: String, c: Char): Long {
        val count = s.count{ it == c }.toLong()
        return count * (count - 1) / 2 + count
    }
}
