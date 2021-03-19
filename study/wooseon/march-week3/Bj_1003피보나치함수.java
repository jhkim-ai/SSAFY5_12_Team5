package baekjoon.silver;

import java.io.*;
import java.lang.*;
import java.util.*;

public class Bj_1003피보나치함수 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int T=Integer.parseInt(br.readLine());
		int n=0;
		int [][] num= new int[41][2];
		num[0][0]=1;
		num[0][1]=0;
		num[1][0]=0;
		num[1][1]=1;
		
		for(int i=2;i<=40;i++) {
			num[i][0]=num[i-1][0]+num[i-2][0];
			num[i][1]=num[i-1][1]+num[i-2][1];
		}
		
		StringBuilder sb = new StringBuilder();
		for(int t=1;t<=T;t++) {
			
			n=Integer.parseInt(br.readLine());
			sb.append(num[n][0]+" "+num[n][1]+"\n");
			
			
		}
		System.out.println(sb);
	}
}
