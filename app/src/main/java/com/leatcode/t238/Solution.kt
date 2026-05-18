package com.leatcode.t238

import com.leatcode.util.print

fun main() {
    Solution().productExceptSelf(intArrayOf(1, 2, 3, 4)).joinToString().print()
}

class Solution {


    // using answer as prefix array O(1) space
    fun productExceptSelf(nums: IntArray): IntArray {
        val length = nums.size
        val answer = IntArray(length)

        answer[0] = 1
        for (i in 1 until length) {
            answer[i] = nums[i - 1] * answer[i - 1]
        }

        var rProduct = 1  // contains the product of all the elements to the right
        for (i in nums.lastIndex downTo 0) {
            answer[i] = answer[i] * rProduct
            rProduct *= nums[i]
        }
        return answer
    }

    // prefix and suffix arrays
    fun productExceptSelf2(nums: IntArray): IntArray {
        val result = IntArray(nums.size)
        var prefix = 1
        result[0] = prefix
        for (i in 1 until nums.size) {
            prefix *= nums[i - 1]
            result[i] = prefix
        }

        var suffix = 1
        for (i in nums.size - 1 downTo 0) {
            result[i] *= suffix
            suffix *= nums[i]
        }

        return result
    }

    fun productExceptSelfSimple(nums: IntArray): IntArray {
        val prefixs = IntArray(nums.size)
        for (i in nums.indices) {
            prefixs[i] = nums[i] * prefixs.getOrElse(i - 1) { 1 }
        }

        val suffixes = IntArray(nums.size)
        for (i in nums.size - 1 downTo 0) {
            suffixes[i] = nums[i] * suffixes.getOrElse(i + 1) { 1 }
        }

        return IntArray(nums.size) {
            prefixs.getOrElse(it - 1) { 1 } * suffixes.getOrElse(it + 1) { 1 }
        }
    }
}