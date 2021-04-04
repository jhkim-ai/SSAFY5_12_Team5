package baekjoon.silver;

import java.io.*;
import java.util.*;
import java.lang.*;

public class Bj_2531회전초밥 {

	static int n,d,k,c;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		n=Integer.parseInt(st.nextToken()); //접시의 수
		d=Integer.parseInt(st.nextToken()); // 초밥의 가지수
		k=Integer.parseInt(st.nextToken()); // 연속해서 먹는 접시 수
		c=Integer.parseInt(st.nextToken()); //쿠폰 번호
		
		int[] sushi=new int[n+k];
		for(int i=0;i<n;i++) {
			sushi[i]=Integer.parseInt(br.readLine());
		}
		
		for(int i=0;i<k-1;i++) { //뒤에 k만큼 배열 더 생성
			sushi[n+i]=sushi[i];
		}
		
		int[] visit=new int[d+1]; //초밥 종류 
		
		//초밥 종류 개수
		int cnt=0;
		for(int i=0;i<k;i++) {
			if(visit[sushi[i]]==0) {
				cnt++;
				visit[sushi[i]]++;
			}
			else {
				visit[sushi[i]]++;
			}
		}
		
		int ans=0;
		if(visit[c]==0) {
			ans=ans<cnt+1?cnt+1:ans;
		}else {
			ans=ans<cnt?cnt:ans;
		}
		
		for(int i=k;i<n+k-1;i++) {
			visit[sushi[i-k]]--;
			if(visit[sushi[i-k]]==0) cnt--;
			if(visit[sushi[i]]==0) {
				cnt++;
				visit[sushi[i]]++;
			}
			else {
				visit[sushi[i]]++;
			}
			if(visit[c]==0) {
				ans=ans<cnt+1?cnt+1:ans;
			}
			else {
				ans=ans<cnt?cnt:ans;
			}
		}
		
		System.out.println(ans);
		
	}

	
	
}
