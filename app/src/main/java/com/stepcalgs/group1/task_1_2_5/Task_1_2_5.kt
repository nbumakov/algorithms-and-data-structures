package com.example.stepcalgs.group1.task_1_2_5

fun main() {
    readln().toInt()
    val nums = readln().split(" ").map { it.toInt() }
    val k = readln().toInt() // windowSize

    val result = with(ArrayDeque<Int>(k)) {
        IntArray(nums.size - k + 1).also { result ->
            nums.forEachIndexed { i, n ->
                while (isNotEmpty() && nums[last()] <= n) removeLast()
                add(i)
                if (first() == i - k) removeFirst()
                if (i >= k - 1) result[i - k + 1] = nums[first()]
            }
        }
    }

    println(result.joinToString(" "))
}

