package com.leatcode.t8029

class Solution {
    fun numberOfPoints(nums: List<List<Int>>): Int {

        //TODO make more optimal
        val set = hashSetOf<Int>()
        nums.forEach {
            for (i in it.first()..it.last()) set.add(i)
        }
        return set.size
    }
}