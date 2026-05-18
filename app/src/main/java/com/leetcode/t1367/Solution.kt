package com.leetcode.t1367

import com.leetcode.util.ListNode
import com.leetcode.util.TreeNode

/**
 * Example:
 * var li = ListNode(5)
 * var v = li.`val`
 * Definition for singly-linked list.
 * class ListNode(var `val`: Int) {
 *     var next: ListNode? = null
 * }
 */
/**
 * Example:
 * var ti = TreeNode(5)
 * var v = ti.`val`
 * Definition for a binary tree node.
 * class TreeNode(var `val`: Int) {
 *     var left: TreeNode? = null
 *     var right: TreeNode? = null
 * }
 */
class Solution {
    fun isSubPath(head: ListNode?, root: TreeNode?): Boolean {
        if (root == null) return false

        fun dfs(head: ListNode?, root: TreeNode?): Boolean {
            if (head == null) return true
            if (root == null) return false
            if (head.`val` != root.`val`) return false
            return dfs(head.next, root.left) || dfs(head.next, root.right)
        }

        return dfs(head, root) || isSubPath(head, root.left) || isSubPath(head, root.right)
    }
}