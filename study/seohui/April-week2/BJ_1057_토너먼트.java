package com.BaekJoon.StudyEveryWeek;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.util.StringTokenizer;

public class BJ_1057_토너먼트 {

	public static void main(String[] args) throws IOException {
		BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder output = new StringBuilder();
		StringTokenizer tokens;
		input = new BufferedReader(new StringReader(src));
		tokens = new StringTokenizer(input.readLine());
		
		int N = Integer.parseInt(tokens.nextToken());
		int k = Integer.parseInt(tokens.nextToken());
		int y = Integer.parseInt(tokens.nextToken());
		
		int r = 0;
		
		while(k != y) {
			k = k/2 + k%2; //현재 값과 홀수면 1을 더해줌
			y = y/2 + y%2;
			r++;
		}
		System.out.println(r); //둘은 무조건 붙는다 -1처리 없음
	}
static String src="60000 101 891";
}
