// 1149, RGB 거리
package BOJ;

import java.io.*;
import java.util.*;

public class BOJ_1149 {

	static int N;
	static int[] dp_red, dp_green, dp_blue, red, green, blue;
	
	public static void main(String[] args) throws IOException{

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		dp_red = new int[N];	// 빨강으로 칠할 때 최소 비용
		dp_green = new int[N];	// 초록으로 칠할 때 최소 비용
		dp_blue = new int[N];	// 파랑으로 칠할 때 최소 비용
		red = new int[N];		// 칠하기 위해 드는 비용
		green = new int[N];
		blue = new int[N];
		
		for (int i=0;i<N;i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			red[i] = Integer.parseInt(st.nextToken());
			green[i] = Integer.parseInt(st.nextToken());
			blue[i] = Integer.parseInt(st.nextToken());
		}
		
		dp_red[0] = red[0];
		dp_green[0] = green[0];
		dp_blue[0] = blue[0];
		
		// 빨강으로 칠하기 위해 이전 색은 파랑이나 초록
		// 둘 중 비용이 더 적은 것을 골라 빨강으로 칠하기 위해 필요한 비용 더한다.
		for (int i=1;i<N;i++) {
			dp_red[i] = Math.min(dp_green[i-1], dp_blue[i-1])+red[i];
			dp_green[i] = Math.min(dp_red[i-1], dp_blue[i-1])+green[i];
			dp_blue[i] = Math.min(dp_red[i-1], dp_green[i-1])+blue[i];
		}
		
		// RGB 중 비용이 가장 적은 것을 골라 출력한다.
		System.out.println(Math.min(dp_red[N-1], Math.min(dp_green[N-1], dp_blue[N-1])));
	}

}
