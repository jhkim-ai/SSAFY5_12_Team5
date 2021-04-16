package BOJ;

import java.io.*;
import java.util.*;

public class BOJ_2512_예산 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		long[] budgets = new long[N];
		StringTokenizer st = new StringTokenizer(br.readLine());
		long tot = 0;
		long maxBudget = Integer.MIN_VALUE;
		for (int i = 0; i < N; i++) {
			budgets[i] = Integer.parseInt(st.nextToken());
			tot += budgets[i];
			maxBudget = Math.max(budgets[i], maxBudget);
		}
		// 입력 끝
		
		Arrays.sort(budgets);	// 이분탐색 --> 정렬 필요
		
		long limit = Long.parseLong(br.readLine());
		//System.out.println("tot: "+tot +" limit: "+limit+" maxBudget: "+maxBudget);
		if (tot <= limit) {
			System.out.println(maxBudget);
		} else {
			long start = 0;
			long end = budgets[N-1];
			long max = Long.MIN_VALUE;
			while (start <= end) {
				long mid = (start + end) / 2;
				//System.out.println(start + "~" + end + " : " + mid);
				long total = 0;

				for (int i = 0; i < N; i++) {
					if (budgets[i] > mid) {
						total += mid;
					} else {
						total += budgets[i];
					}
				}
				//System.out.println("total: " + total);
				if (total > limit) {
//					max = mid;
					end = mid -1;
//				System.out.println("end: "+end);
				} else {
					//max = mid;
					start = mid + 1;
					
				}

			}
			System.out.println(end);
		}
	}

}
