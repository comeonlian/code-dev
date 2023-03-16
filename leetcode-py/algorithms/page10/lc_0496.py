#!/usr/bin/env python
# -*- coding: utf-8 -*-

# @Time    : 2022/3/20 18:27
# @Author  : lianliang
# @File    : lc_0480.py

"""
LC 496 : 下一个更大元素 I
nums1 中数字 x 的 下一个更大元素 是指 x 在 nums2 中对应位置 右侧 的 第一个 比 x 大的元素。
给你两个 没有重复元素 的数组 nums1 和 nums2 ，下标从 0 开始计数，其中nums1 是 nums2 的子集。
对于每个 0 <= i < nums1.length ，找出满足 nums1[i] == nums2[j] 的下标 j ，并且在 nums2 确定 nums2[j] 的 下一个更大元素 。
如果不存在下一个更大元素，那么本次查询的答案是 -1 。
返回一个长度为 nums1.length 的数组 ans 作为答案，满足 ans[i] 是如上所述的 下一个更大元素 。

示例 1：
输入：nums1 = [4,1,2], nums2 = [1,3,4,2].
输出：[-1,3,-1]
解释：nums1 中每个值的下一个更大元素如下所述：
- 4 ，用加粗斜体标识，nums2 = [1,3,4,2]。不存在下一个更大元素，所以答案是 -1 。
- 1 ，用加粗斜体标识，nums2 = [1,3,4,2]。下一个更大元素是 3 。
- 2 ，用加粗斜体标识，nums2 = [1,3,4,2]。不存在下一个更大元素，所以答案是 -1 。

示例 2：
输入：nums1 = [2,4], nums2 = [1,2,3,4].
输出：[3,-1]
解释：nums1 中每个值的下一个更大元素如下所述：
- 2 ，用加粗斜体标识，nums2 = [1,2,3,4]。下一个更大元素是 3 。
- 4 ，用加粗斜体标识，nums2 = [1,2,3,4]。不存在下一个更大元素，所以答案是 -1 。

提示：
1 <= nums1.length <= nums2.length <= 1000
0 <= nums1[i], nums2[i] <= 10^4
nums1和nums2中所有整数 互不相同
nums1中的所有整数同样出现在 nums2 中
"""
from typing import List

'''
1、计算出nums2中每个元素的下一个更大元素，存到dict中
2、遍历nums1，匹配dict取出value存到数组中即可
'''


class Solution:
    def nextGreaterElement(self, nums1: List[int], nums2: List[int]) -> List[int]:
        index, next_nums2, res = 0, {}, []
        for x in nums2:
            has_next = False
            for y in nums2[index + 1:]:
                if y > x:
                    next_nums2[x] = y
                    has_next = True
                    break
            if not has_next:
                next_nums2[x] = -1
            index = index + 1
        for x in nums1:
            list.append(res, next_nums2[x])
        return res


nums1 = [4,1,2]
nums2 = [1,3,4,2]
solution = Solution()
print(solution.nextGreaterElement(nums1, nums2))

"""
执行结果：通过显示详情查看示例代码添加备注
执行用时：36 ms, 在所有 Python3 提交中击败了87.42%的用户
内存消耗：15.1 MB, 在所有 Python3 提交中击败了44.93%的用户通过测试用例：16 / 16
"""
