package com.leatcode.t2840

class Solution {
    fun checkStrings(s1: String, s2: String): Boolean {
        val even1 = mutableListOf<Char>().apply {
            for (i in s1.indices step 2) add(s1[i])
            sort()
        }
        val even2 = mutableListOf<Char>().apply {
            for (i in s2.indices step 2) add(s2[i])
            sort()
        }
        val odd1 = mutableListOf<Char>().apply {
            for (i in 1..s1.lastIndex step 2) add(s1[i])
            sort()
        }
        val odd2 = mutableListOf<Char>().apply {
            for (i in 1..s2.lastIndex step 2) add(s2[i])
            sort()
        }
        return even1 == even2 && odd1 == odd2
    }
}