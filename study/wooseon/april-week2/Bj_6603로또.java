package baeckjoon;

import java.util.*;
import java.io.*;

public class Bj_6603로또 {

	static int k;
	static int[] array;
	static StringBuilder sb=new StringBuilder();
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		while(true) {
			st= new StringTokenizer(br.readLine());
			k=Integer.parseInt(st.nextToken());
			num=new int[6];
			if(k==0) break;
			
			array = new int[k];
			for(int i=0;i<k;i++) {
				array[i]=Integer.parseInt(st.nextToken());
			}
			
			comb(0,0);
			sb.append("\n");
		}
		
		System.out.println(sb);

	}
	
	static int[] num;
	
	static void comb(int cnt,int start) {
		if(cnt==6) {
			for(int i=0;i<6;i++) {
				sb.append(num[i]+" ");
			}
			sb.append("\n");
			return;
		}
		
		for(int i=start;i<k;i++) {
			num[cnt]=array[i];
			comb(cnt+1,i+1);
		}
		
	}

}
