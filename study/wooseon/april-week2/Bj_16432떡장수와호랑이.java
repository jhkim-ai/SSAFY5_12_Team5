package baeckjoon;

import java.io.*;
import java.util.*;

/**
 * @since 2021. 4. 8.
 * @author 최우선
 * @see
 * @mem
 * @time
 * @caution *말순선생* - 되돌리기 
 */

public class Bj_16432떡장수와호랑이 {

	static int n;
	static int[][] ricecake;
	static boolean[][] visit;
  	static StringBuilder sb = new StringBuilder();
  	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		
		n=Integer.parseInt(br.readLine());
		ricecake=new int[n][];
		visit = new boolean[n][];
		ans=new int[n];
		for(int i=0;i<n;i++) {
			st=new StringTokenizer(br.readLine());
			int m=Integer.parseInt(st.nextToken());
			ricecake[i]=new int[m];
			visit[i]=new boolean[m];
			for(int j=0;j<m;j++) {
				ricecake[i][j]=Integer.parseInt(st.nextToken());
			}
		}
		
		find(0,-1);
		System.out.println(-1);
		
		
		
	}
	
	static int[] ans;
	
	static void find(int cnt,int a) {
		if(cnt==n) {
			for(int j=0;j<n;j++) {
				sb.append(ans[j]+"\n");
			}
			System.out.println(sb);
			System.exit(0);
		}

		for(int j=0;j<ricecake[cnt].length;j++) {
			if(!visit[cnt][j]&&a!=ricecake[cnt][j]) {
				visit[cnt][j]=true;
				ans[cnt]=ricecake[cnt][j];
				
				//업데이트 되는 내용을 새로운 변수에 넣어준다면 꼭 되돌려야함
				//되돌리기 헷갈리다면 그냥 바로 매개변수로 넣어주자.
				find(cnt+1,ricecake[cnt][j]);
			}
		}
	}
	

}
