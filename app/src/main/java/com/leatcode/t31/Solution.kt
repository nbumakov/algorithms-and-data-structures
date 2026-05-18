package com.leatcode.t31

import com.leatcode.util.print

fun main() {
    val a = intArrayOf(1, 3, 2)
    Solution().nextPermutation2(a)
    a.print()
}

class Solution {

    // [1,2,3], [1,3,2], [2, 1, 3], [2, 3, 1], [3,1,2], [3,2,1].
    fun nextPermutation2(nums: IntArray) {
        var breakIndex = -1
        for (i in nums.lastIndex - 1 downTo 0) {
            if (nums[i] < nums[i + 1]) {
                breakIndex = i
                break
            }
        }

        if (breakIndex == -1) {
            nums.sort()
            return
        }

        // find the closest value to nums[breakIndex]
        var next: IndexedValue<Int> = IndexedValue(breakIndex + 1, nums[breakIndex + 1])
        for (i in breakIndex + 2..nums.lastIndex) {
            if (nums[i] > nums[breakIndex] && nums[i] < next.value) {
                next = IndexedValue(i, nums[i])
            }
        }

        nums[next.index] = nums[breakIndex]
        nums[breakIndex] = next.value

        nums.sort(fromIndex = breakIndex + 1)
    }

    fun nextPermutation(nums: IntArray) {
        if (nums.size <= 1) return

        var curr = nums.last()
        var index = -1
        for (i in nums.lastIndex - 1 downTo 0) {
            if (nums[i] > curr) curr = nums[i] else {
                index = i
                break
            }
        }

        if (index == -1) {
            nums.sort()
            return
        }

        val temp = nums[index]
        nums[index] = nums[index + 1]
        nums[index + 1] = temp

        nums.sort(fromIndex = index + 1)
    }

}
