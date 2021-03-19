package BOJ.Silver.dp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class B1003_피보나치수열 {
	static int[][] dp;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int TC = Integer.parseInt(br.readLine());
		for (int tc=0;tc<TC;tc++) {
			int N = Integer.parseInt(br.readLine());
			dp = new int[N+2][2];
			dp[0][0] = 1;
			dp[0][1] = 0;
			dp[1][0] = 0;
			dp[1][1] = 1;
			for (int i=2;i<=N;i++) {
				dp[i][0] = dp[i-1][0]+dp[i-2][0];
				dp[i][1] = dp[i-1][1]+dp[i-2][1];
			}
			
			System.out.println(dp[N][0]+" "+dp[N][1]);
		}
	}
}
