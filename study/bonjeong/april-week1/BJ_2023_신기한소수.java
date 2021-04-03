package study11;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
// 11111111 ~ 99999999
public class BJ_2023_신기한소수 {
	static int N;
	static StringBuilder sb;
	static boolean[] primeNumbers;
	static int Max;
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		sb = new StringBuilder();
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		
		dfs("", 0);
		System.out.println(sb);
	}
	
	// 탐색 함수
	static void dfs(String s, int cnt) {
		if(cnt == N) { // N 자릿수 되면
			sb.append(s).append("\n"); // 출력
			return;
		}
		// 7331
		for(int i = 1; i <= 9; i++) { // 1부터 자릿수 하나씩 추가해주기
			s = s + i; 
			if(isPrimeNumber(Integer.parseInt(s)) == true) { // 앞 자릿수부터 소수이면
				dfs(s, cnt+1); // 다음 수 추가
			}
			
			s = s.substring(0, s.length()-1);
		}
	}
	
	// 소수판별
	static boolean isPrimeNumber(int n) {
		if(n == 1) // 1이면
			return false; // 소수 아님
		
		for(int i = 2; i <= Math.sqrt(n); i++) { //n의 제곱근까지
			if(n % i == 0) // 나누어 떨어지면
				return false; // 소수 아님
		}
		
		return true;
	}
}
