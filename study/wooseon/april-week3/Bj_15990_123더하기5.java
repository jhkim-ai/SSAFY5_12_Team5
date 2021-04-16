package baeckjoon;

import java.util.*;
import java.io.*;

public class Bj_15990_123더하기5 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int T=Integer.parseInt(br.readLine());
		long mod=1000000009L;
		
		long[][] dp=new long[100001][4];
		dp[1][1]=dp[2][2]=dp[3][1]=dp[3][2]=dp[3][3]=1;
		
		for(int i=4;i<=100000;i++) {
			dp[i][1]=(dp[i-1][2]+dp[i-1][3])%mod;
			dp[i][2]=(dp[i-2][1]+dp[i-2][3])%mod;
			dp[i][3]=(dp[i-3][1]+dp[i-3][2])%mod;
		}
		
		for(int t=1;t<=T;t++) {
			int n=Integer.parseInt(br.readLine());
			sb.append((dp[n][1]+dp[n][2]+dp[n][3])%mod+"\n");
		}
		System.out.println(sb);
		
	}

}
