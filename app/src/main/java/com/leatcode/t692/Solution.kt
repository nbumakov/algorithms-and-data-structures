package com.leatcode.t692

import com.leatcode.util.print
import java.util.PriorityQueue

fun main() {
//    Solution().topKFrequent(arrayOf("i", "love", "leetcode", "i", "love", "coding"), 2).print()
//    Solution().topKFrequent(arrayOf("the","ove", "leetcode", "i", "love", "coding"), 2).print()
    Solution().topKFrequent(arrayOf("a", "b", "c", "a", "a", "b", "c", "a", "c", "c"), 2).print()
}

class Solution {
    fun topKFrequent(words: Array<String>, k: Int): List<String> {
        val freq = hashMapOf<String, Int>().apply {
            words.forEach { this[it] = getOrDefault(it, 0) + 1 }
        }
        val heap = PriorityQueue<String> { a, b ->
            when {
                freq[b] == freq[a] -> b.compareTo(a)
                else -> freq[a]!! - freq[b]!!
            }
        }
        freq.keys.forEach {
            heap.add(it)
            if (heap.size > k) heap.remove()
        }

        return List(heap.size) {
            heap.remove()
        }.reversed()
    }
}