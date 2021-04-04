package baekjoon.gold;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.PriorityQueue;

/**
 * @since 2021. 4. 4.
 * @author 최우선
 * @see
 * @mem
 * @time
 * @caution dp문제가 아니고, 들어갈때마다 정렬해줘야하는 우선순위 큐 문제
 */


public class Bj_1715카드정렬하기 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n=Integer.parseInt(br.readLine());
		PriorityQueue<Integer> num= new PriorityQueue<>();
		
		for(int i=0;i<n;i++) {
			int x=Integer.parseInt(br.readLine());
			num.add(x);
		}
		
		int sum=0;
		int cardnum=0;
		if(n==1) sum=0;
		else{
			while(!num.isEmpty()) {
				if(num.size()==1) break;
				cardnum=num.poll()+num.poll();
				num.add(cardnum);
				sum+=cardnum;
				
			}
		}

		System.out.println(sum);
	}

}
