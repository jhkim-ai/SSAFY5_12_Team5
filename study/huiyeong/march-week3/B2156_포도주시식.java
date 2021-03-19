package BOJ.Silver.dp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class B2156_포도주시식 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int[] numbers = new int[N+1];
		int[] dp = new int[N+1];
		for (int i=1;i<=N;i++) {
			numbers[i] = Integer.parseInt(br.readLine());
		}
		
		
		dp[1] = numbers[1];
		if (N>=2) dp[2] = numbers[1]+numbers[2];
		
		for (int i=3;i<=N;i++) {
			dp[i] = Math.max(dp[i-2]+numbers[i], dp[i-3]+numbers[i-1]+numbers[i]);
			dp[i] = Math.max(dp[i], dp[i-1]);
		}
		
		System.out.println(dp[N]);
	}
}
