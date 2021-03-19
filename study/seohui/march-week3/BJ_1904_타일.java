package com.BaekJoon.StudyEveryWeek;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.util.StringTokenizer;

public class BJ_1904_타일 {
	static BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder output = new StringBuilder();
	static StringTokenizer tokens;
	static int[] dp = new int[1000001];

	public static void main(String[] args) throws NumberFormatException, IOException {
		input = new BufferedReader(new StringReader(src));

		int N = Integer.parseInt(input.readLine());
		dp[0] = 0; //초기 앞의 내용
		dp[1] = 1;
		dp[2] = 2;
		// -1 로 초기화
		for (int i = 3; i < dp.length; i++) {
			dp[i] = -1;
		}
		System.out.println(Tile(N)); // Tile 호출한 것 그대로 출력
	}
	
	//점화식
	public static int Tile(int N) {
		if (dp[N] == -1) {
			dp[N] = (Tile(N - 1) + Tile((N - 2))) % 15746;
		}
		return dp[N];

	}

	static String src = "4";
}
