package com.BaekJoon.StudyEveryWeek;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BJ_1197_최소_스패닝_트리 {
	

static class Edge implements Comparable<Edge>{
	int from; 
	int to;
	int weight;
	public Edge(int from, int to, int weight) {
		super();
		this.from = from;
		this.to = to;
		this.weight = weight;
	}
	@Override
	public int compareTo(Edge o) {
		return Integer.compare(this.weight, o.weight);
	}

}
	static int[] parents;
	static int V,E;
	static Edge [] edge;
	public static void main(String[] args) throws IOException {
		BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder output = new StringBuilder();
		StringTokenizer tokens;
		
		input = new BufferedReader(new StringReader(src));
		
		tokens = new StringTokenizer(input.readLine());
		
		V = Integer.parseInt(tokens.nextToken());
		E = Integer.parseInt(tokens.nextToken());
		
		edge = new Edge[E];
		parents = new int[V+1];
		
		for(int i = 0; i< E; i++) {
			tokens = new StringTokenizer(input.readLine());
			
			int a = Integer.parseInt(tokens.nextToken());
			int b = Integer.parseInt(tokens.nextToken());
			int c = Integer.parseInt(tokens.nextToken());
			
			edge[i] = new Edge(a, b, c);
		}
		
		//=====================입력부
		
		System.out.println(kruskal());
		
		
		
	}
	
	
	
	private static int kruskal() {
		int result = 0; int cnt = 0;
		
		Arrays.sort(edge);
		
		
		make();
		
		for(Edge edgelist : edge) {
			if(union(edgelist.from, edgelist.to)) {
				result += edgelist.weight;
				//항상 모두 완성된 트리의 간선 은 정점 -1이다
				if(++cnt == V-1) return result;
			}
		}
		
		
		return result;
	}
	//최종 부모 찾기
	static int find(int a) {
		if(a == parents[a]) return a;
		return parents[a] = find(parents[a]);
	}
	//같은 트리 인지 확인
	static boolean union(int a, int b){
		int aRoot = find(a);
		int bRoot = find(b);
		
		if(aRoot == bRoot) return false;
		parents[aRoot] = bRoot;
		return true;
	}
	
	//초기화
	static void make() {
		for(int i = 1; i<=V; i++) {
			parents[i] = i;
		}
	}
	static String src="3 3\r\n" + 
			"1 2 1\r\n" + 
			"2 3 2\r\n" + 
			"1 3 3";
}
