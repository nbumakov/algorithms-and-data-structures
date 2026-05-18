package com.leatcode.t278

import com.leatcode.util.print

/* The isBadVersion API is defined in the parent class VersionControl.
      fun isBadVersion(version: Int) : Boolean {} */

abstract class VersionControl {

    abstract fun firstBadVersion(n: Int): Int

    protected fun isBadVersion(mid: Int): Boolean =
        mid >= 1702766719
}

fun main() {
    Solution().firstBadVersion(2126753390).print()
}

class Solution : VersionControl() {
    override fun firstBadVersion(n: Int): Int {
        var l = 1
        var r = n

        while (l <= r) {
            val mid = l + (r - l) / 2
            when {
                isBadVersion(mid) -> r = mid - 1
                else -> l = mid + 1
            }
        }

        return l
    }

}