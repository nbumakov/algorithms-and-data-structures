package com.leetcode.t3499

class Solution {
    fun maxActiveSectionsAfterTrade(s: String): Int {
        // разбиваем на группы одинаковых символов: (символ, длина)
        val groups = mutableListOf<Group>()
        var i = 0
        while (i < s.length) {
            var j = i
            while (j < s.length && s[j] == s[i]) j++
            groups.add(Group(s[i], (j - i)))
            i = j
        }

        val totalOnes = s.count { it == '1' }
        var maxGain = 0
        // берём каждую внутреннюю группу единиц и суммируем соседние нули
        for (k in 1 until groups.size - 1) {
            if (groups[k].char == '1') {
                maxGain = maxOf(maxGain, groups[k - 1].length + groups[k + 1].length)
            }
        }
        return totalOnes + maxGain
    }

    private data class Group(
        val char: Char,
        val length: Int
    )
}

/**
 * Оптимизированная версия: один проход, O(1) по памяти, без аллокаций.
 *
 * Раны чередуются 0/1/0/1..., поэтому два соседних нулевых рана всегда
 * разделены ровно одним внутренним раном единиц. Держим длину предыдущего
 * нулевого рана; встретив очередной нулевой ран, обновляем выигрыш = prev + cur.
 */
class Solution2 {
    fun maxActiveSectionsAfterTrade(s: String): Int {
        val n = s.length
        var totalOnes = 0
        var maxGain = 0
        var prevZeros = -1 // длина предыдущего нулевого рана; -1 = его ещё не было

        var i = 0
        while (i < n) {
            val c = s[i]
            var j = i
            while (j < n && s[j] == c) j++
            val len = j - i

            if (c == '1') {
                totalOnes += len
            } else {
                if (prevZeros >= 0) {
                    maxGain = maxOf(maxGain, prevZeros + len)
                }
                prevZeros = len
            }
            i = j
        }

        return totalOnes + maxGain
    }
}