package BOJ;

import java.io.*;
import java.util.Arrays;

public class BOJ_9461 {

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		long[] dp = new long[101];
		dp[1] = 1;
		dp[2] = 1;
		dp[3] = 1;
		// 점화식
		for (int i = 4; i < 101; i++) {
			dp[i] = dp[i - 3] + dp[i - 2];
		}
		
		int T = Integer.parseInt(br.readLine());
		for (int t = 1; t <= T; t++) {
			int n = Integer.parseInt(br.readLine());
			sb.append(dp[n]).append("\n");
		}
		System.out.println(sb);

	}

}
