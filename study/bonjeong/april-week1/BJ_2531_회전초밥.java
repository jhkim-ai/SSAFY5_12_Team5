package study11;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BJ_2531_회전초밥 {
	static boolean[] kinds;
	static int answ;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken()); // 초밥 벨트에 놓인 접시 수
		int d = Integer.parseInt(st.nextToken()); // 초밥의 가짓수
		int k = Integer.parseInt(st.nextToken()); // 연속해서 먹는 접시 수
		int c = Integer.parseInt(st.nextToken()); // 쿠폰 번호
		
		int[] arr = new int[N];
		for(int n = 0; n < N; n++) {
			arr[n] = Integer.parseInt(br.readLine()); // 초밥 저장 배열
		}
		
		for(int n = 0; n < N; n++) {
			kinds = new boolean[d+1];
			int cnt = 1;
			
			for(int m = n; m < (n + k); m++) {
				if(kinds[arr[m % N]] == false) {
					kinds[arr[m % N]] = true; // 초밥 담기
					cnt++; 
					
					if(arr[m % N] == c) { // 쿠폰 있으면
						cnt--; // 뺴기
					}
				}
			}
			
			if(cnt == k+1) {
				answ = cnt;
				break;
			}
			
			answ = Math.max(answ, cnt);
		}
		
		System.out.println(answ);
		
	}
}
