package study11;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ_7453_합이0인네정수 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine()); // 4000
		int[] A = new int[N];
		int[] B = new int[N];
		int[] C = new int[N];
		int[] D = new int[N];
		
		for(int n = 0; n < N; n++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			A[n] = Integer.parseInt(st.nextToken());
			B[n] = Integer.parseInt(st.nextToken());
			C[n] = Integer.parseInt(st.nextToken());
			D[n] = Integer.parseInt(st.nextToken());
		}
		
		
	}
}
