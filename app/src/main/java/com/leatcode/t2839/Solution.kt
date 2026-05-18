package com.leatcode.t2839

class Solution {

    fun canBeEqual(s1: String, s2: String): Boolean =
        setOf(s1[0], s1[2]) == setOf(s2[0], s2[2]) && setOf(s1[1], s1[3]) == setOf(s2[1], s2[3])
}