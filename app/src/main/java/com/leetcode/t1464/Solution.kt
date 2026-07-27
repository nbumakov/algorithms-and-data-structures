package com.leetcode.t1464

import java.util.PriorityQueue

/**
 * Min-heap размера 2: держим два наибольших элемента, лишний выбрасываем.
 * O(n) по времени, O(1) по памяти, но с боксингом и аллокацией очереди.
 */
class Solution {
    fun maxProduct(nums: IntArray): Int = with(PriorityQueue<Int>()) {
        for (n in nums) {
            add(n)
            if (size > 2) remove()
        }
        (poll() - 1) * (poll() - 1)
    }
}

/**
 * Без вспомогательных структур: ищем индекс максимума, затем максимум
 * среди оставшихся индексов. Два прохода, O(n) по времени, O(1) по памяти.
 */
class Solution2 {
    fun maxProduct(nums: IntArray): Int = with(nums.indices.asSequence()) {
        val i = maxBy { nums[it] }
        val j = filter { it != i }.maxBy { nums[it] }
        (nums[i] - 1) * (nums[j] - 1)
    }
}
