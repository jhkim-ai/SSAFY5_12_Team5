package baekjoon.gold;

import java.util.*;
import java.io.*;

/**
 * @since 2021. 3. 31.
 * @author 최우선
 * @see
 * @mem
 * @time
 * @caution
 */

public class Bj_2023신기한소수 {

	static int n;
	static StringBuilder sb=new StringBuilder();
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n=Integer.parseInt(br.readLine());
		

		
		dfs("",0);
		System.out.println(sb);
		

	}
	
	static void dfs(String s,int len) {
		if(len==n) {
			sb.append(s+"\n");
			return;
		}
		
		for(int i=1;i<=9;i++) {
			if(isPrime(Integer.parseInt(s+i))) {
				dfs(s+i,len+1);
			}
		}
		
		
	}
	
	//소수인지 그때그때 바로 판단하기
	static boolean isPrime(int k) {
		if(k==1) return false;
		
		int sqrt=(int)Math.sqrt(k);
		for(int i=2;i<=sqrt;i++) {
			if(k%i==0) return false;
		}
		
		return true;
	}

}
