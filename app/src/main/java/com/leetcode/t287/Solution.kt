package com.leetcode.t287

import com.leetcode.util.print

fun main() {
    Solution().findDuplicate(intArrayOf(1, 2, 3, 2)).print()
}

/**
 * Treat the array as a linked list: from index i go to nums[i].
 * Since every value is in [1, n], every value is a valid index, so you can walk forever.
 * A forever-walk over finitely many nodes must loop. The loop forms exactly where
 * two indices share the same value, which is the duplicate, so the cycle entrance = the answer.
 * Start at index 0 because 0 is never a value, so nothing points into it: a safe head.
 *
 * Now find the entrance with Floyd.
 * Phase 1: slow steps 1, fast steps 2; they meet inside the loop.
 * Phase 2: reset slow to the start, move both by 1; they meet at the entrance.
 *
 * Why phase 2 works. By the meeting, slow has traveled a whole number of laps.
 * Why: fast went twice as far, and its extra distance is the laps it wound to catch up,
 * which equals slow's own path. So slow's path = k·C.
 * Of those steps, the first F reach the entrance; the remaining a = k·C − F are wound inside the loop.
 * So from the meeting point, F more steps: a + F = k·C ≡ entrance again.
 * From START, F steps also reach the entrance.
 * Hence two pointers (one from START, one from the meeting point, each moving 1 step) meet exactly at the entrance = the duplicate.
 */
class Solution {

    fun findDuplicate(nums: IntArray): Int {
        var slow = nums[0]
        var fast = nums[0]

        do {
            slow = nums[slow]
            fast = nums[nums[fast]]
        } while (slow != fast)

        slow = nums[0]
        while (slow != fast) {
            slow = nums[slow]
            fast = nums[fast]
        }

        return slow
    }
}