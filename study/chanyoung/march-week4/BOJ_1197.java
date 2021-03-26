// 1197, 최소 스패닝 트리 | https://www.acmicpc.net/problem/1197
package BOJ;

import java.io.*;
import java.util.*;

public class BOJ_1197 {

	static int findSet(int a) {
		if (parents[a] == a) return a;
		return parents[a] = findSet(parents[a]);
	}
	
	static boolean union(int a, int b) {
		a = findSet(a);
		b = findSet(b);
		if (a==b) return false;
		
		parents[b] = a;
		return true;
	}
	
	static class Edge implements Comparable<Edge> {
		int from; // 시작점
		int to; // 도착점
		int weight; // 가중치

		public Edge(int from, int to, int weight) {
			super();
			this.from = from;
			this.to = to;
			this.weight = weight;
		}

		@Override
		public String toString() {
			return "Edge [from=" + from + "to=" + to + ", weight=" + weight + "]";
		}

		@Override
		public int compareTo(Edge o) {
			// TODO Auto-generated method stub
			return Integer.compare(this.weight, o.weight);
		}
	}

	static int parents[];
	static Edge[] edgeList;

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int V = Integer.parseInt(st.nextToken());
		int E = Integer.parseInt(st.nextToken());


		parents = new int[V];
		edgeList = new Edge[E];

		for (int i = 0; i < E; i++) {
			st = new StringTokenizer(br.readLine());
			int from = Integer.parseInt(st.nextToken());
			int to = Integer.parseInt(st.nextToken());
			int weight = Integer.parseInt(st.nextToken());
			// list.get(from).add(new Edge(to, weight));
			edgeList[i] = new Edge(from-1, to-1, weight);
		}

		Arrays.sort(edgeList);

		for (int i = 0; i < V; i++) {
			parents[i] = i;
		}
		
		int result = 0;
		int count = 0;	
		
		for (Edge edge: edgeList) {
			if (union(edge.from, edge.to)) {
				result+=edge.weight;
				if (++count==V-1) break;
			}
		
		}
		System.out.println(result);

	}

}
