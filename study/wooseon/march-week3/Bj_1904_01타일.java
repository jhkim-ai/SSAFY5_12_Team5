package baekjoon.silver;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/**
 * @since 2021. 3. 15.
 * @author 최우선
 * @see
 * @mem
 * @time
 * @caution 숫자가 굉장히!!! 커지기 떄문에 구할때마다 % 해주어야한다.. 나머지....
 */

public class Bj_1904_01타일 {

	static int N;
	static int [] num;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N=Integer.parseInt(br.readLine());
		num=new int [N+1];
		
		num[0]=1;
		num[1]=1;
		
		for(int i=2;i<=N;i++) {
			num[i]=(num[i-1]+num[i-2])%15746;
		}
		
		long ans=num[N]%15746;
		
		System.out.println(ans);
	}

}
