package com.leatcode.t454

import com.leatcode.util.print


fun main() {
    Solution().fourSumCount(
        intArrayOf(0),
        intArrayOf(0),
        intArrayOf(0),
        intArrayOf(0),
    ).print()
}

class Solution {

    // N2
    fun fourSumCount(nums1: IntArray, nums2: IntArray, nums3: IntArray, nums4: IntArray): Int {
        fun getSumQty(nums1: IntArray, nums2: IntArray): HashMap<Int, Int> =
            hashMapOf<Int, Int>().apply {
                nums1.forEach { n1 ->
                    nums2.forEach { n2 ->
                        val key = n1 + n2
                        this[key] = getOrDefault(key, 0) + 1
                    }
                }
            }

        val map1 = getSumQty(nums1, nums2)
        val map2 = getSumQty(nums3, nums4)
        return map1.keys.fold(0) { acc, s ->
            acc + map1.getOrDefault(s, 0) * map2.getOrDefault(-s, 0)
        }
    }

    fun fourSumCount_N3(nums1: IntArray, nums2: IntArray, nums3: IntArray, nums4: IntArray): Int {
        val qtyMap = hashMapOf<Int, Int>().apply {
            nums4.forEach {
                this[it] = this.getOrDefault(it, 0) + 1
            }
        }
        var count = 0
        nums1.forEach { n1 ->
            nums2.forEach { n2 ->
                nums3.forEach { n3 ->
                    count += qtyMap.getOrDefault(-(n1 + n2 + n3), 0)
                }
            }
        }
        return count
    }
}