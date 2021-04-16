package com.BaekJoon.IM;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BJ_2512_예산 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder output = new StringBuilder();
		StringTokenizer tokens;	
		
		input = new BufferedReader(new StringReader(src));

		int n = Integer.parseInt(input.readLine()); // 예산 갯수
		
		int [] arr = new int[n];
		
		tokens = new StringTokenizer(input.readLine());
		
		int sum = 0;
		
		for(int i = 0; i< n; i++) {
			int a = Integer.parseInt(tokens.nextToken());
			arr[i] = a;
			sum += a;
		}
		int total = Integer.parseInt(input.readLine());
		Arrays.sort(arr);
		
		if(sum <= total) {
			System.out.println(arr[n-1]); // 배정 가능 한 상태면 그냥 max 출력
		}
		else if(sum > total){
			 long ans=0;
			  long left=0; //보통 left는 0으로 하더라고
		      long right=arr[n-1];
		      
		      while(left<=right) { //이분탐색의 필수 과정....
		         long mid=(left+right)/2;
		         long s=0;
		         for(int i=0;i<n;i++) {
		            if(arr[i]>=mid) s+=mid;
		            else {
		               s+=arr[i];
		            }
		         }
		         if(s>total) {
		            right=mid-1;
		         }else {
		            left=mid+1;
		            ans=Math.max(ans, mid);
		         }
		      }
		      System.out.println(ans);
		}
		
	}
	static String src="3\r\n" + 
			"4 4 5\r\n" + 
			"6";
}
