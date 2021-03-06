package BOJ.Silver.dp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class B9461_파도반수열 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int TC = Integer.parseInt(br.readLine());
		for (int tc=0;tc<TC;tc++) {
			int N = Integer.parseInt(br.readLine());
			long[] dp = new long[N+1];
			dp[1]=1;
			if (N>1) dp[2]=1;
			if (N>2) dp[3]=1;
			for (int i=4;i<=N;i++) {
				dp[i] = dp[i-2]+dp[i-3];
			}
			sb.append(dp[N]+"\n");
		}
		System.out.println(sb);
	}
}
