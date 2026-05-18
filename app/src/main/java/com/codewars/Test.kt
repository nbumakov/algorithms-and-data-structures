package com.codewars

import com.leetcode.util.print
import java.util.PriorityQueue
import kotlin.math.ceil
import kotlin.math.floor
import kotlin.math.log
import kotlin.math.log2
import kotlin.math.min
import kotlin.math.pow
import kotlin.math.sqrt


fun toCamelCase(str: String): String =
    str.split('-', '_')
        .mapIndexed { i, it -> if (i != 0) it.capitalize() else it }
        .joinToString("")

private val complementaryMap = mapOf(
    'A' to 'T',
    'T' to 'A',
    'C' to 'G',
    'G' to 'C',
)

fun makeComplement(dna: String): String =
    dna.map(complementaryMap::get).joinToString("")

object ASum {

    fun findNb(m: Long): Long {
        var n = 0L
        var volume = m
        while (volume > 0) {
            n++
            volume -= n * n * n
        }
        return n
    }
}

fun comp(a: IntArray?, b: IntArray?): Boolean =
    a != null && b != null && a.sorted().map { it * it } == b.sorted()

fun bouncingBall(h: Double, bounce: Double, window: Double): Int {
    if (h <= 0.0 || h < window || bounce !in 0.0..1.0) return -1

    val numberOfJumps = generateSequence(h) { it * bounce }
        .takeWhile { it > window }
        .count()

    return 2 * numberOfJumps - 1
}

// window = h*bounce^n
// n = lg (window / h) / lg bounce
fun bouncingBall2(h: Double, bounce: Double, window: Double): Int = when {
    h <= 0 || bounce !in 0.0..1.0 || window > h -> -1
    else -> 2 * ceil(log(window / h, bounce)).toInt() - 1
}

fun inArray(array1: Array<String>, array2: Array<String>): Array<String> =
    array1.toSortedSet().filter { a1 -> array2.any { it.contains(a1) } }.toTypedArray()

object EnoughIsEnough {
    fun deleteNth(elements: IntArray, maxOcurrences: Int): IntArray {
        val qtyMap = hashMapOf<Int, Int>()
        return elements.asSequence()
            .onEach { qtyMap[it] = qtyMap.getOrDefault(it, 0) + 1 }
            .filter { qtyMap[it]!! <= maxOcurrences }
            .toList()
            .toIntArray()
    }
}

object PrimeDecomp {
    fun factors(l: Int): String {
        var x = l
        val result = StringBuilder()
        for (i in 2..l / 2) {
            var count = 0
            while (x % i == 0) {
                count++
                x /= i
            }
            when {
                count > 1 -> result.append("($i**$count)")
                count == 1 -> result.append("($i)")
            }
            if (x == 1) break
        }
        return result.toString()
    }
}

fun orderWeight(string: String): String =
    string.split(" ")
        .sortedWith(compareBy({ it.weight() }, { it }))
        .joinToString(" ")

private fun String.weight(): Int =
    toCharArray().sumOf { it.digitToInt() }

fun race(v1: Int, v2: Int, g: Int): IntArray {
    if (v2 <= v1) return intArrayOf(-1, -1, -1)

    val speed = v2 - v1
    val time = 60 * 60 * g / speed
    val h = time / 3600
    val m = (time - 3600 * h) / 60
    val s = time - 3600 * h - 60 * m

    return intArrayOf(h, m, s)
}

fun rgb(r: Int, g: Int, b: Int): String =
    "${r.toHexColor()}${g.toHexColor()}${b.toHexColor()}".uppercase()

private fun Int.toHexColor() = buildString {
    val value = coerceIn(0..255).toString(16)
    if (value.length < 2) append('0')
    append(value)
}

fun rgb2(r: Int, g: Int, b: Int) = listOf(r, g, b).joinToString("") {
    it.coerceIn(0..255).toString(16).padStart(2, '0')
}.uppercase()

fun nextBiggerNumber(n: Long): Long {
    val nList = n.toString().toList()
    val index = nList.windowed(2)
        .indexOfLast { (a, b) -> a < b }
        .takeIf { it >= 0 }
        ?: return -1L

    val head = nList.take(index)
    val tail = nList.takeLast(nList.size - index - 1).toMutableList()

    // find closet element to nArray[index]
    val next = tail
        .withIndex()
        .filter { it.value > nList[index] }
        .minBy { it.value }!!

    tail[next.index] = nList[index]

    return (head + next.value + tail.sorted()).joinToString("").toLong()
}


fun consecKprimes(k: Int, arr: LongArray): Int {

    fun Long.isKprime(): Boolean {
        var x = this
        var count = 0
        for (i in 2..this) {
            while (x % i == 0L) {
                count++
                x /= i
            }
            if (count > k) break
        }
        return count == k
    }

    return arr.asSequence()
        .map { it.isKprime() }
        .windowed(2)
        .count { it[0] && it[1] }
}

fun countKprimes(k: Int, start: Long, end: Long): LongArray =
    (start..end).filter { it.isKprime(k) }.toLongArray()

fun puzzle(s: Int): Int {
    val onePrimes = countKprimes(1, 2, s.toLong()).toSet()
    val threePrimes = countKprimes(3, 2, s.toLong())
    val sevenPrimes = countKprimes(7, 2, s.toLong())

    var count = 0

    for (c in sevenPrimes) {
        for (b in threePrimes) {
            if (onePrimes.contains(s - b - c)) count++
        }
    }
    return count
}

private fun Long.isKprime(k: Int): Boolean {
    if (this == 1L) return k == 0

    for (i in 2..sqrt(toDouble()).toInt()) {
        if (this % i == 0L) return (this / i).isKprime(k - 1)
    }
    return k == 1
}

object ClosestWeight {

    fun closest(strng: String): Array<IntArray> =
        strng.split(" ")
            .asSequence()
            .mapIndexed { index, s -> intArrayOf(s.weight(), index, s.toInt()) }
            .sortedBy { it[0] }
            .windowed(2)
            .minByOrNull { it[1][0] - it[0][0] }!!
            .toTypedArray()

    private fun String.weight(): Int =
        toCharArray().sumOf { it.digitToInt() }
}

object Kata {

    // https://www.codewars.com/kata/596d34df24a04ee1e3000a25/train/kotlin
    fun countOnes(left: Long, right: Long): Long =
        countOnesSingle(right) - countOnesSingle(left - 1);

    // 0 0 1
    // 0 1 0
    // 0 1 1
    // 1 0 0
    // 1 0 1
    // 1 1 0
    // 1 1 1
    private fun countOnesSingle(n: Long): Long {
        var curr = n.toDouble()
        var result = 0L
        while (curr > 0) {
            val k = floor(log2(curr))
            result += (2.0.pow(k - 1) * k + 1).toLong()
            curr -= 2.0.pow(k)
            result += curr.toLong()
        }
        return result
    }
}

tailrec fun gcd(a: Long, b: Long): Long = if (b == 0L) a else gcd(b, a % b)
fun solution(numbers: LongArray): Long = numbers.size * numbers.reduce { acc, l -> gcd(acc, l) }


val lcsMemo = hashMapOf<Pair<String, String>, String>()
fun lcs(a: String, b: String): String {
    if (a.isEmpty() || b.isEmpty()) return ""

    return lcsMemo.getOrPut(a to b) {
        if (a[0] == b[0]) {
            a[0] + lcs(a.substring(1), b.substring(1))
        } else {
            val skipA = lcs(a.substring(1), b)
            val skipB = lcs(a, b.substring(1))
            if (skipA.length > skipB.length) skipA else skipB
        }
    }
}

fun lcs2(a: String, b: String): String {
    val dp = Array(a.length + 1) { Array(b.length + 1) { "" } }

    for (i in a.indices.reversed()) {
        for (j in b.indices.reversed()) {
            dp[i][j] = when {
                a[i] == b[j] -> a[i] + dp[i + 1][j + 1]
                dp[i + 1][j].length > dp[i][j + 1].length -> dp[i + 1][j]
                else -> dp[i][j + 1]
            }
        }
    }

    return dp[0][0]
}

object Decomp {

    fun decompose(n: Long): String =
        tryDecompose(n, n * n)?.joinToString(" ") ?: "null"

    private fun tryDecompose(n: Long, sum: Long): List<Long>? {
        if (sum == 0L) return emptyList()
        if (sum == (n - 1) * (n - 1)) return listOf(n - 1)

        val next = min(n - 1, sqrt(sum.toDouble()).toLong())
        return (next downTo 1)
            .firstNotNullOfOrNull { tryDecompose(it, sum - it * it)?.plus(it) }
    }
}

fun top3(s: String): List<String> =
    s.lowercase()
        .replace(Regex("[^a-z']"), " ")
        .split(" ")
        .filter { it.isNotBlank() && !it.all { it == '\'' } }
        .groupingBy { it }
        .eachCount()
        .entries
        .sortedByDescending { it.value }
        .take(3)
        .map { it.key }

fun dblLinear(n: Int): Int {
    val queue = PriorityQueue<Int>().apply { add(1) }
    return generateSequence {
        val curr = queue.remove()!!
        while (queue.isNotEmpty() && queue.peek() == curr) queue.remove()
        queue.add(2 * curr + 1)
        queue.add(3 * curr + 1)
        curr
    }.drop(n).first()
}

fun dblLinear2(n: Int): Int = with(sortedSetOf(1)) {
    for (i in 1..n) {
        val curr = first().also { remove(it) }
        add(2 * curr + 1)
        add(3 * curr + 1)
    }
    first()
}

fun rangeExtraction(arr: IntArray): String {
    if (arr.isEmpty()) return ""

    val intervals = mutableListOf(intArrayOf(arr[0], arr[0]))

    for (i in 1..arr.lastIndex) {
        val n = arr[i]
        if (intervals.last()[1] == n - 1) {
            intervals.last()[1] = n
        } else {
            intervals.add(intArrayOf(n, n))
        }
    }

    return intervals.joinToString(separator = ",") {
        when {
            it[0] == it[1] -> "${it[0]}"
            it[0] == it[1] - 1 -> "${it[0]},${it[1]}"
            else -> "${it[0]}-${it[1]}"
        }
    }
}

fun main() {
//    guess().print()
//    ASum.findNb(1071225).print()
//    bouncingBall(3.0, 0.66, 1.5).print()
//    PrimeDecomp.factors(86240).print()
//    PrimeDecomp.factors(4 * 7 * 31 * 4051).print()
//    orderWeight("103 123 4444 99 2000").print()
//    race(720, 850, 70).print()
//    race(80, 91, 37).print()
//    rgb(0, 0, 255).print()
//    nextBiggerNumber(1234321).print()
//    nextBiggerNumber(132).print()
//    nextBiggerNumber(144).print()
//    countKprimes(3, 0, 100).joinToString().print()
//    ClosestWeight.closest("202174 186 177039 94 189002 66 94235 112 326314 66 48")
//        .forEach { it.print() }

//    Kata.countOnes(4, 7).print()
//    lcs2("132535365", "123456789").print()
//    lcs2("abcdefghijklmnopq", "apcdefghijklmnobq").print()
//    lcs2("anothertest", "notatest").print()
//    lcs2("a", "b").print()
//    lcs2("nothardlythefinaltest", "zzzfinallyzzz").print()

//    Decomp.decompose(11).print()
//    Decomp.decompose(10).print()
//    Decomp.decompose(7).print()

//    top3("e e e e DDD ddd DdD: ddd ddd aa aA Aa, bb cc cC e e e").print()
//    top3("  //wont won't won't \"").print()

    dblLinear(3).print()
    dblLinear2(3).print()
}