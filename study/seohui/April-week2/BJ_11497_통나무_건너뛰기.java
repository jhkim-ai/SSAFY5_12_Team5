package com.BaekJoon.StudyEveryWeek;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BJ_11497_통나무_건너뛰기 {

	static int[] temp;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder output = new StringBuilder();
		StringTokenizer tokens;
		
		input = new BufferedReader(new StringReader(src));
		
		int T = Integer.parseInt(input.readLine());
		
		for(int tc = 1; tc <=T; tc++) {
			
			int n = Integer.parseInt(input.readLine());
			int [] arr = new int [n];
			
			tokens = new StringTokenizer(input.readLine());
			
			for(int a = 0; a<n; a++) {
				arr[a] = Integer.parseInt(tokens.nextToken());
			}
			Arrays.sort(arr);
			
			int fin = check(arr);
			output.append(fin).append("\n");

			
		}
		System.out.println(output);
	}
	static int check(int[] make) {
		
		int result =0;
		int n = make.length;
		
		int left = 0; // 앞 쪽부터 채워나가기
		int right = n-1;// 뒤쪽 부터 채워나가기
		int[] temp = new int[n];
		
		for(int i = 0; i<n; i++) {
			if(i%2 ==0) {
				temp[left] = make[i];
				left++;
			}
			else {
				temp[right] = make[i];
				right--;
			}
		}
		System.out.println(Arrays.toString(temp));
		result = Math.abs(temp[0] - temp[n-1]); // 연결되어 있는 배열이므로 첫 값과 마지막 값의 비교 필요
		for(int a = 0; a<n-1; a++) {
			result = Math.max(result, Math.abs(temp[a] - temp[a+1]));
		}
		
		return result;
	}
	static String src="3\r\n" + 
			"7\r\n" + 
			"13 10 12 11 10 11 12\r\n" + 
			"5\r\n" + 
			"2 4 5 7 9\r\n" + 
			"8\r\n" + 
			"6 6 6 6 6 6 6 6";
}
