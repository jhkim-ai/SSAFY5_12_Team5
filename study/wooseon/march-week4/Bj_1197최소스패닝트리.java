package baekjoon.gold;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;


public class Bj_1197최소스패닝트리 {

	
	static int V,E;
	static int parents[];
	static Edge[] edgeList;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		V=Integer.parseInt(st.nextToken());
		E=Integer.parseInt(st.nextToken());
		
		parents=new int[V+1];
		edgeList=new Edge[E];
		
		for(int i=0;i<E;i++) {
			st=new StringTokenizer(br.readLine());
			int from=Integer.parseInt(st.nextToken());
			int to=Integer.parseInt(st.nextToken());
			int w=Integer.parseInt(st.nextToken());
			edgeList[i]=new Edge(from,to,w);
		}
		
		//간선리스트 가중치 기준 오름차순 정렬
		Arrays.sort(edgeList);
		
		make();
		int result=0;
		int count=0;
		for(Edge edge : edgeList) {
			if(union(edge.from,edge.to)) {
				result+=edge.weight;
				if(++count == V-1) break;
			}
		}
		
		System.out.println(result);
	}
	
	
	
	static class Edge implements Comparable<Edge> {
		int from,to,weight;
		
		public Edge(int from,int to, int weight) {
			super();
			this.from=from;
			this.to=to;
			this.weight=weight;
		}

		@Override
		public int compareTo(Edge o) {
			
			return Integer.compare(this.weight, o.weight);
		}
		
		
	}

	static void make() {
		for(int i=1;i<=V;i++) {
			parents[i]=i;
		}
	}
	
	static int findSet(int a) {
		if(parents[a]==a) return a;
		
		return parents[a]=findSet(parents[a]);
	}
	
	static boolean union(int a,int b) {
		int aRoot = findSet(a);
		int bRoot= findSet(b);
		if(aRoot==bRoot) return false;
		
		parents[bRoot] = aRoot;
		return true;
	}
	
}
