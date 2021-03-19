// 1932, 정수 삼각형
package BOJ;

import java.io.*;
import java.util.*;

public class BOJ_1932 {

	static int n;
	static int[][] arr, dp;

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		n = Integer.parseInt(br.readLine());

		arr = new int[n+1][n+1];
		dp = new int[n+1][n+1];

		for (int i = 1; i <= n; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int j = 1; j <= i; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
			}
		}

//		for (int i=0;i<n+1;i++) {
//			for (int j=0;j<n+1;j++) {
//				System.out.print(arr[i][j]+" ");
//			}
//			System.out.println();
//		}
//		System.out.println("==============");
		
		dp[1][1] = arr[1][1];
		for (int i = 2; i <= n; i++) {
			for (int j = 1; j <= i; j++) {
				// 왼쪽 대각선 or 오른쪽 대각선 중 큰 수를 선택해 현재 값과 더한다.
				dp[i][j] = Math.max(dp[i-1][j-1], dp[i-1][j]) + arr[i][j];
			}
		}
		
//		for (int i=0;i<n+1;i++) {
//			for (int j=0;j<n+1;j++) {
//				System.out.print(dp[i][j]+" ");
//			}
//			System.out.println();
//		}
		
		
		int max = Integer.MIN_VALUE;
		for (int i: dp[n]) {
			if (i > max) {
				max = i;
			}
		}
		
		System.out.println(max);
	}

}
