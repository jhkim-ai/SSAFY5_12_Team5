package BOJ.Silver.dp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class B1932_정수삼각형 {
	static int[][] dp;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int[][] tri = new int[N][];
		dp = new int[N][];
		for (int i=0;i<N;i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			tri[i] = new int[i+1];
			dp[i] = new int[i+1];
			for (int j=0;j<tri[i].length;j++) {
				tri[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		dp[0][0] = tri[0][0];
		int MAX = Integer.MIN_VALUE;
		for (int i=1;i<N;i++) {
			int cnt = 0;
			for (int j=0;j<tri[i].length;j++) {
				dp[i][j] = dp[i-1][cnt]+tri[i][j];
				if (j>0 && j<tri[i].length-1) {
					dp[i][j] = Math.max(dp[i][j], dp[i-1][++cnt]+tri[i][j]);
				}
				
				if (i==N-1) MAX = Math.max(MAX, dp[i][j]);
			}
		}
		
		System.out.println(MAX);
	}
}
