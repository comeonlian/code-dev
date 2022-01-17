package com.leolian.leetcode.questionbank.algorithm.medium;

/**
 * LC 97 : 交错字符串
 * 给定三个字符串 s1、s2、s3，请你帮忙验证 s3 是否是由 s1 和 s2 交错 组成的。
 * 两个字符串 s 和 t 交错 的定义与过程如下，其中每个字符串都会被分割成若干 非空 子字符串：
 * s = s1 + s2 + ... + sn
 * t = t1 + t2 + ... + tm
 * |n - m| <= 1
 * 交错 是 s1 + t1 + s2 + t2 + s3 + t3 + ... 或者 t1 + s1 + t2 + s2 + t3 + s3 + ...
 * 提示：
 * a + b 意味着字符串 a 和 b 连接。
 * 0 <= s1.length, s2.length <= 100
 * 0 <= s3.length <= 200
 * s1、s2、和 s3 都由小写英文字母组成
 * <p>
 * 示例1
 * https://assets.leetcode.com/uploads/2020/09/02/interleave.jpg
 * 输入：s1 = "aabcc", s2 = "dbbca", s3 = "aadbbcbcac"
 * 输出：true
 * <p>
 * 示例2
 * 输入：s1 = "aabcc", s2 = "dbbca", s3 = "aadbbbaccc"
 * 输出：false
 * <p>
 * 示例3
 * 输入：s1 = "", s2 = "", s3 = ""
 * 输出：true
 */
public class LC_0097 {

	public static void main(String[] args) {
		LC_0097 lc0097 = new LC_0097();

		String s1 = "aabcc", s2 = "dbbca", s3 = "aadbbbaccc";
		System.out.println(lc0097.isInterleave(s1, s2, s3));
	}

	/**
	 * 1、首先如果 |s1| + |s2| = |s3|，那 s3必然不可能由 s1 和 s2交错组成。在 |s1| + |s2| = |s3| 时，我们可以用动态规划来求解
	 * 2、我们定义 f(i, j) 表示 s1的前 i 个元素和 s2 的前 j 个元素是否能交错组成 s3 的前 i + j 个元素。
	 * 3、如果 s1 的第 i 个元素和 s3 的第 i + j 个元素相等，那么 s1 的前 i 个元素和 s2 的前 j 个元素是否能交错组成 s3 的前 i + j 个元素取决于 s1 的
	 * 4、前 i - 1 个元素和 s2 的前 j 个元素是否能交错组成 s3 的前 i + j - 1 个元素，即此时 f(i, j) 取决于 f(i - 1, j) 在此情况下如果 f(i - 1, j) 为真，则 f(i, j) 也为真
	 * 5、同样的，如果 s2 的第 j 个元素和 s3 的第 i + j 个元素相等并且 f(i, j - 1) 为真，则 f(i, j) 也为真
	 * 6、于是我们可以推导出这样的动态规划转移方程：f(i, j) = [f(i - 1, j) and s1(i - 1) = s3(p)] or [f(i, j - 1) and s2(j - 1) = s3(p)]
	 * 7、其中 p = i + j - 1。边界条件为 f(0, 0) = True
	 */
	public boolean isInterleave(String s1, String s2, String s3) {
		int n = s1.length(), m = s2.length(), t = s3.length();
		if ((n + m) != t) {
			return false;
		}
		boolean[][] dp = new boolean[n+1][m+1];
		dp[0][0] = true;
		for (int i = 0; i <= n; i++) {
			for (int j = 0; j <= m; j++) {
				int p = i + j - 1;
				if (i > 0) {
					dp[i][j] = dp[i][j] || (dp[i - 1][j] && s1.charAt(i - 1) == s3.charAt(p));
				}
				if (j > 0) {
					dp[i][j] = dp[i][j] || (dp[i][j - 1] && s2.charAt(j - 1) == s3.charAt(p));
				}
			}
		}
		return dp[n][m];
	}

	/*
	执行用时：6 ms, 在所有 Java 提交中击败了39.82%的用户
	内存消耗：36.5 MB, 在所有 Java 提交中击败了88.29%的用户
	通过测试用例：106 / 106
	*/
}
