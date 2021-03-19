import java.io.*;

public class Main {
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		long dp[] = new long[41];
		dp[0] = 0;
		dp[1] = 1;
		
		for(int i = 2; i<41; ++i) {
			dp[i] = dp[i-1] + dp[i-2];
		}
		
		StringBuilder sb = new StringBuilder();
		int T = Integer.parseInt(br.readLine());
		while(T-->0) {
			int x = Integer.parseInt(br.readLine());
			if(x==0) {
				sb.append(1).append(' ').append(0).append('\n');
				continue;
			}
			sb.append(dp[x-1]).append(' ').append(dp[x]).append('\n');
		}
		
		System.out.println(sb);
	}
	
}