package baekjoon.silver;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.StringTokenizer;

public class Bj_1149RGB거리 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int n=Integer.parseInt(br.readLine());
		int ans=0;
		int[][] roof=new int[n][3];
		
		
		StringTokenizer st;
		
		for(int i=0;i<n;i++) {
			st=new StringTokenizer(br.readLine());
			for(int j=0;j<3;j++) {
				roof[i][j]=Integer.parseInt(st.nextToken());
			}
		}
		
		
		
		for(int i=1;i<n;i++) {
			//boolean[] visit=new boolean[3];
			for(int j=0;j<3;j++) {
				if(j==0) {
					int a=roof[i][j]+roof[i-1][1];
					int b=roof[i][j]+roof[i-1][2];
					
					int min=Math.min(a, b);
					//System.out.println(min);
					roof[i][j]=min;
				}
				else if(j==1) {
					int a=roof[i][j]+roof[i-1][0];
					int b=roof[i][j]+roof[i-1][2];
					
					int min=Math.min(a, b);
					//System.out.println(min);
					roof[i][j]=min;
				}
				else {
					int a=roof[i][j]+roof[i-1][0];
					int b=roof[i][j]+roof[i-1][1];
					
					int min=Math.min(a, b);
					//System.out.println(min);
					roof[i][j]=min;
				}
			}
		}
		
		int min=Integer.MAX_VALUE;
		for(int i=0;i<3;i++) {
			min=Math.min(min, roof[n-1][i]);
		}
		
		System.out.println(min);

	}

}
