package baeckjoon;

import java.util.*;
import java.io.*;

public class Bj_14501퇴사 {

	static int n;
	static ArrayList<int[]> list= new ArrayList<>();
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		n=Integer.parseInt(br.readLine());
		
		for(int i=0;i<n;i++) {
			st=new StringTokenizer(br.readLine());
			int t=Integer.parseInt(st.nextToken());
			int p =Integer.parseInt(st.nextToken());
			
			
			list.add(new int[] {t,p});
		}
		
		
		
		dfs(0,0);
		
		System.out.println(max);
		
	}
	
	static int max=0;
	
	static void dfs(int day,int cost) {

		if(day>=n) {
			max=Math.max(max, cost);
			return;
		}
		
		if(day+list.get(day)[0]<=n) dfs(day+list.get(day)[0],cost+list.get(day)[1]);
		else dfs(day+list.get(day)[0],cost);
		
		dfs(day+1,cost);
	}

}
