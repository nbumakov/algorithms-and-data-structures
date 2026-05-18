package com.leatcode.t2828

class Solution {
    fun isAcronym(words: List<String>, s: String): Boolean {
        if (words.size != s.length) return false
        for (i in words.indices) {
            if (s[i] != words[i].first()) {
                return false
            }
        }
        return true
    }
}