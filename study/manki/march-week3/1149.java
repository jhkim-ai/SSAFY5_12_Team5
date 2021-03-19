import java.io.*;
import java.util.*;

public class Main {
	
	public static void main(String args[]) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());

		int[][] dp = new int[2][3];
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		for(int i = 0; i<3; ++i) {
			dp[0][i] = Integer.parseInt(st.nextToken());
		}
		
		for(int i = 1; i<N; ++i) {
			st = new StringTokenizer(br.readLine());
			dp[1][0] = Integer.parseInt(st.nextToken()) + Math.min(dp[0][1], dp[0][2]);
			dp[1][1] = Integer.parseInt(st.nextToken()) + Math.min(dp[0][0], dp[0][2]);
			dp[1][2] = Integer.parseInt(st.nextToken()) + Math.min(dp[0][0], dp[0][1]);
			dp[0] = dp[1].clone();
		}
		System.out.print(Math.min(Math.min(dp[0][0], dp[0][1]), dp[0][2]));
	}
	
}