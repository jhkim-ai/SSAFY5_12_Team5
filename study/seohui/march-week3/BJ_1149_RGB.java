package com.BaekJoon.StudyEveryWeek;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.util.StringTokenizer;

public class BJ_1149_RGB {
	static BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder output = new StringBuilder();
	static StringTokenizer tokens;

	public static void main(String[] args) throws NumberFormatException, IOException {
		input = new BufferedReader(new StringReader(src));

		int Red = 0;
		int Green = 1;
		int Blue = 2;

		int N = Integer.parseInt(input.readLine());
		
		int[][] Cost = new int[N][3];
		
		for (int i = 0; i < N; i++) {
			tokens = new StringTokenizer(input.readLine());
			
			Cost[i][Red] = Integer.parseInt(tokens.nextToken());
			Cost[i][Green] = Integer.parseInt(tokens.nextToken());
			Cost[i][Blue] = Integer.parseInt(tokens.nextToken());
		}
		// 1부터 N-1까지 각 i별 i-1의 서로 다른 색상 중 최솟값을 누적하여 더한다.
		for (int i = 1; i < N; i++) {
			
			Cost[i][Red] += Math.min(Cost[i-1][Green], Cost[i-1][Blue]); // 이전의 배열에서 가장 작은 G, B
			Cost[i][Green] += Math.min(Cost[i-1][Red], Cost[i-1][Blue]); // 이전의 배열에서 가장 작은 R, B
			Cost[i][Blue] += Math.min(Cost[i-1][Red], Cost[i-1][Green]); // 이전의 배열에서 가장 작은 R, G
		}
		
		int first_min = Math.min(Cost[N-1][Red], Cost[N-1][Green]); // 이전의 배열에서 가장 작은 R, G
		int second_min = Math.min(first_min, Cost[N-1][Blue]);
		System.out.println(second_min);

	}

	static String src = "3\r\n" + 
			"26 40 83\r\n" + 
			"49 60 57\r\n" + 
			"13 89 99";
}
