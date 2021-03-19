package baekjoon.silver;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/**
 * @since 2021. 3. 18.
 * @author 최우선
 * @see
 * @mem
 * @time
 * @caution 인덱스와.. 정답범위...!!
 */


public class Bj_9461파도반수열 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int T=Integer.parseInt(br.readLine());
		
		
		int n=0;
		long[] num=new long[101];
		num[1]=1;
		num[2]=1;
		num[3]=1;
		for(int i=4;i<=100;i++) {
			num[i]=num[i-3]+num[i-2];
		}
		for(int t=1;t<=T;t++) {
			n=Integer.parseInt(br.readLine());
			sb.append(num[n]+"\n");
		}
		System.out.println(sb);

	}

}
