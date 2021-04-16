import java.io.*;
import java.util.*;

//12 27
public class Main {

	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder sb = new StringBuilder();
	static int N, M ,cmp;
	static List<Integer>[][] weight;
	static boolean[] visited;
	static final int L =0;
	static final int H = 1;
	public static void main(String[] args) throws Exception {
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");

		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		cmp = N / 2;
		
		weight = new ArrayList[2][N];
		visited = new boolean[N];
		
		for (int i = 0; i < N; ++i) {
			weight[L][i] = new ArrayList<Integer>();
			weight[H][i] = new ArrayList<Integer>();
		}
		for (int i = 0; i < M; ++i) {
			st = new StringTokenizer(br.readLine(), " ");
			// a > b
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			--a;
			--b;
			weight[L][b].add(a);
			weight[H][a].add(b);

		}

		int res = 0;
		for (int i = 0; i < N; ++i) {
			Arrays.fill(visited,false);
			if(dfs(i,L,0)>cmp) {
				res++;
				Arrays.fill(visited,false);
			}
			else if(dfs(i,H,0)>cmp) res++;
		}
		System.out.println(res);
	}
	private static int dfs(int idx, int k,int dep) {
		int res = 0;
		visited[idx]=true;
		for(int num : weight[k][idx]) {
			if(!visited[num]) {
				visited[num]=true;
				res++;
				res+=dfs(num,k,dep+1);
			}
		}
		
		return res;
	}

}

