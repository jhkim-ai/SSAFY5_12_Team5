package baekjoon.silver;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Bj_1932정수삼각형 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st=null;
		
		int n=Integer.parseInt(br.readLine());
		int[][] tri=new int[n][];
		
		for(int i=0;i<n;i++) {
			tri[i]=new int[i+1];
		}
		
		for(int i=0;i<n;i++) {
			st=new StringTokenizer(br.readLine());
			for(int j=0;j<i+1;j++) {
				tri[i][j]=Integer.parseInt(st.nextToken());
			}
		}
		
		tri[1][0]+=tri[0][0];
		tri[1][1]+=tri[0][0];
		int idx=0;
		for(int i=2;i<n;i++) {
			for(int j=0;j<i+1;j++) {
				if(j==0) {
					tri[i][j]+=tri[i-1][j];
				}
				else if(j==i) {
					tri[i][j]+=tri[i-1][j-1];
				}else {
					int a=tri[i][j]+tri[i-1][j-1];
					int b=tri[i][j]+tri[i-1][j];
					tri[i][j]=Math.max(a, b);
				}
				
			}
		}
		
		int max=0;
		for(int i=0;i<n;i++) {
			max=Math.max(max, tri[n-1][i]);
		}

		
		System.out.println(max);
	}

}
