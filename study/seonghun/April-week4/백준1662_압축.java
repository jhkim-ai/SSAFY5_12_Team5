import java.io.*;
import java.util.*;

public class 백준1662_압축 {

	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder sb = new StringBuilder();

	static final char OPEN = '(';
	static final char CLOSE = ')';
	static boolean[] visited;
	static String input;
	public static void main(String[] args) throws Exception {
		input = br.readLine();
		visited = new boolean[input.length()];
	
		System.out.println(dfs(0));
	}
	private static int dfs(int idx) {
		int leng = 0;
		
		for(int i=idx;i<input.length();++i) {
			
			if(visited[i]) continue;
			
			visited[i]=true;
			char c = input.charAt(i);
			
			if(c==OPEN) {
				leng--;
				int cnt = input.charAt(i-1)-'0';
				leng+=cnt*dfs(idx);
			}
		
			else if(c==CLOSE) {
				return leng;
			}
			
			else {
				leng++;
			}
		}
		
		
		return leng;
	}

}
