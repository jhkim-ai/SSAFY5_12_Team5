import java.io.*;

public class Main {
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		StringBuilder sb = new StringBuilder();
		
		long[] arr = new long[101];
		arr[0] = 1;
		arr[1] = 1;
		arr[2] = 1;
		arr[3] = 2;
		arr[4] = 2;
		
		for(int i = 5; i<101; ++i) {
			arr[i] = arr[i-1]+arr[i-5];
		}
		
		while(T-->0) {
			int x = Integer.parseInt(br.readLine());
			sb.append(arr[x-1]).append('\n');
		}
		System.out.println(sb);
	}
	
}
