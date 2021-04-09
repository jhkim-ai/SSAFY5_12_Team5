package baeckjoon;

import java.util.*;
import java.io.*;

/**
 * @since 2021. 4. 7.
 * @author 최우선
 * @see
 * @mem
 * @time
 * @caution 수열로 풀면 터짐..
 */

public class Bj_11497통나무건너뛰기 {
	
	static int[] array;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb=new StringBuilder();
		int T=Integer.parseInt(br.readLine());
		
		for(int t=1;t<=T;t++) {
			int n=Integer.parseInt(br.readLine());
			array=new int[n];
			int[] tmp=new int[n];
			boolean[] visit=new boolean[n];
			
			st=new StringTokenizer(br.readLine());
			for(int i=0;i<n;i++) {
				array[i]=Integer.parseInt(st.nextToken());
			}
			Arrays.sort(array);
			
			int max=0;
			int idx=0;
			for(int i=0;i<n;i+=2) {
				tmp[idx++]=array[i];
				visit[i]=true;
			}
			for(int i=n-1;i>=0;i-=2) {
				if(visit[i]) i--;
				tmp[idx++]=array[i];
				visit[i]=true;
			}
			
			
			for(int i=0;i<n;i++) {
				int tm=0;
				if(i==0) {
					int a=Math.abs(tmp[i]-tmp[n-1]);
					int b=Math.abs(tmp[i]-tmp[i+1]);
					tm=Math.max(a, b);
				}
				else if(i==n-1) {
					int a=Math.abs(tmp[i]-tmp[n-1]);
					int b=Math.abs(tmp[i]-tmp[i-1]);
					tm=Math.max(a, b);
				}
				else {
					int a=Math.abs(tmp[i]-tmp[i-1]);
					int b=Math.abs(tmp[i]-tmp[i+1]);
					tm=Math.max(a, b);
				}
				max=Math.max(max, tm);
			}
			sb.append(max+"\n");
		}
		System.out.println(sb);

	}

}
