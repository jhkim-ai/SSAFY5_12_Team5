package baeckjoon;

import java.util.*;
import java.io.*;

public class Bj_18222투에모스문자열 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		//int 범위를 넘어선다
		long n =Long.parseLong(br.readLine());
		
		//앞으로 적용할 규칙은 offset 0 에 적용되는 규칙이기 때문에 -1 해준다
		n--;
		int cnt=0;
		
		//n을 2진수로 나타낸다 이때 1의 개수를 세준다
		//1의 개수는 수를 찾아가는 수행의 단계 
		//개수를 %2는 반전의 횟수  
		//내 대가리로는 생각할 수 없었던 문제...
		while(n!=0) {
			if(n%2==1) {
				cnt++;
			}
			n/=2;
		}
		
		cnt=cnt%2;
		System.out.println(cnt);
		

	}

}
