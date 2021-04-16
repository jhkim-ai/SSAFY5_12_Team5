package BOJ;

import java.io.*;
import java.util.*;

public class BOJ_1747_소수_팰린드롬 {
	public static void main(String[] args) throws IOException {
		
		// 에라토스테네스 체
		boolean isPrime[] = new boolean[1003002];
		Arrays.fill(isPrime, true);
		isPrime[1] = false;
		for (int i = 2; i < 1003002; i++) {
			for (int j = 2 * i; j < 1003002; j += i) {
				isPrime[j] = false;
			}
		}

		// 1000000 넘는 소수&팰린드롬 --> 1003001
//		for (int i=2;i<10000010;i++) {	
//			if (isPrime[i]&isPalindrome(i)) {
//				System.out.println(i);
//				if (i > 1000000) break;
//			}
//		}
		
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());

		while (true) {
			if (isPrime[N] && isPalindrome(N)) {
				break;
			}
			N++;
		}
		System.out.println(N);
	}

	static boolean isPalindrome(int x) {
		String num = x + "";	// 문자열로 형변환
		int start = num.length() - 1;
		int end = 0;

		while (start >= end) {
			if (num.charAt(start) != num.charAt(end)) {
				return false;
			}
			start--;
			end++;
		}
		return true;

	}
}
