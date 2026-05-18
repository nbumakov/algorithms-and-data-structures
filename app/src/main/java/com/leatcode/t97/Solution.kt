package com.leatcode.t97

import com.leatcode.util.print
import kotlin.math.abs

fun main() {
    Solution().isInterleave("aabcc", "dbbca", "aadbbcbcac").print()
//    Solution().isInterleave("", "dbbca", "aadbbcbcac").print()
}

class Solution {


    // TODO: DP
    // Top-down + memo
    fun isInterleave(s1: String, s2: String, s3: String): Boolean {
        if (s1.length + s2.length != s3.length) return false

        val visited = hashSetOf<Params>()

        fun dfs(params: Params): Boolean {
            val (p1, p2, n, m, fromS1) = params
            if (p1 == s1.length && p2 == s2.length) return abs(n - m) <= 1
            if (p1 > s1.length || p2 > s2.length) return false
            if (visited.contains(params)) return false

            var ans = false
            if (p1 < s1.length && s1[p1] == s3[p1 + p2]) {
                ans = ans || if (fromS1 == true) {
                    dfs(Params(p1 + 1, p2, n, m, true))
                } else {
                    dfs(Params(p1 + 1, p2, n + 1, m, true))
                }
            }
            if (p2 < s2.length && s2[p2] == s3[p1 + p2]) {
                ans = ans || if (fromS1 == false) {
                    dfs(Params(p1, p2 + 1, n, m, false))
                } else {
                    dfs(Params(p1, p2 + 1, n, m + 1, false))
                }
            }

            visited.add(params)
            return ans
        }

        return dfs(Params(0, 0, 0, 0, null))
    }

    data class Params(
        val p1: Int,
        val p2: Int,
        val n: Int,
        val m: Int,
        val fromS1: Boolean?
    )
}