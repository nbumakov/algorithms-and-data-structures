package com.leetcode.t3658

// LeetCode 3658. GCD of Odd and Even Sums

// Вариант 1: считаем суммы циклом, НОД — алгоритмом Евклида. O(n) по времени.
class SolutionBruteForce {
    fun gcdOfOddEvenSums(n: Int): Int {
        var sumOdd = 0
        var sumEven = 0
        for (i in 1..n) {
            sumOdd += 2 * i - 1
            sumEven += 2 * i
        }

        fun gcd(a: Int, b: Int): Int {
            if (b == 0) return a
            return gcd(b, a % b)
        }

        return gcd(sumOdd, sumEven)
    }
}

// Вариант 2: суммы по формулам арифметической прогрессии,
// НОД — алгоритмом Евклида. O(log n) по времени.
class SolutionFormula {
    fun gcdOfOddEvenSums(n: Int): Int {
        val sumOdd = n * n
        val sumEven = n * (n + 1)

        fun gcd(a: Int, b: Int): Int {
            if (b == 0) return a
            return gcd(b, a % b)
        }

        return gcd(sumOdd, sumEven)
    }
}

/**
 * Вариант 3: сумма первых n нечётных чисел = n^2, первых n чётных = n(n+1).
 * gcd(n^2, n(n+1)) = n * gcd(n, n+1) = n, так как соседние числа взаимно просты.
 * Ответ всегда n. O(1).
 */
class Solution {
    fun gcdOfOddEvenSums(n: Int): Int = n
}
