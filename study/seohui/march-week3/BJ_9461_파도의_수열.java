package com.BaekJoon.StudyEveryWeek;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.util.StringTokenizer;

public class BJ_9461_파도의_수열 {
	static BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder output = new StringBuilder();
	static StringTokenizer tokens;
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		input = new BufferedReader(new StringReader(src));
		
		long [] dp = new long [101];
		
		dp[1] =1; // 초기 점화식이 없는 부분 
		dp[2] =1;
		dp[3] =1;
		dp[4] =2;
		dp[5] =2;
		
		//점화식 
		for(int i = 6; i< 101; i++) {
			dp[i] = dp[i-2] + dp[i-3];
		}
		
		int T = Integer.parseInt(input.readLine());
		
		//출력하기
		for(int tc = 1; tc <=T; tc++) {
			int x = Integer.parseInt(input.readLine());
			output.append(dp[x]).append("\n");
		}
		
		System.out.println(output);
	}
	static String src="2\r\n" + 
			"6\r\n" + 
			"12";
}
