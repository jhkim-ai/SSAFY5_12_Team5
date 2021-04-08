package BOJ;

import java.io.*;
import java.util.*;

public class BOJ_6603_로또 {

	static StringBuilder sb = new StringBuilder();

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		while (true) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int k = Integer.parseInt(st.nextToken());
			if (k == 0)
				break;
			int[] S = new int[k];
			int[] combs = new int[6];
			for (int i = 0; i < k; i++) {
				S[i] = Integer.parseInt(st.nextToken());
			}
			// 입력 끝
			comb(0, 0, combs, S);
			sb.append("\n");
		}
		System.out.println(sb);

	}

	static void comb(int cnt, int start, int[] combs, int[] S) {
		if (cnt == 6) {
			for (int i = 0; i < cnt; i++) {
				sb.append(S[combs[i]] + " ");
			}
			sb.append("\n");
			return;
		}

		for (int i = start; i < S.length; i++) {
			combs[cnt] = i;
			comb(cnt + 1, i + 1, combs, S);
		}

	}

}
