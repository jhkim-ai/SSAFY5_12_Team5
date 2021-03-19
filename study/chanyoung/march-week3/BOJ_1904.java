// 1904, 01타일
package BOJ;

import java.io.*;

public class BOJ_1904 {

	static int N;
	static int[] dp = new int[1000001];

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		dp[1] = 1;
		dp[2] = 2;

		// 점화식
		for (int i = 3; i <= 1000000; i++) {
			dp[i] = (dp[i - 1] + dp[i - 2]) % 15746;
		}

		N = Integer.parseInt(br.readLine());
		System.out.println(dp[N]);

	}
}
