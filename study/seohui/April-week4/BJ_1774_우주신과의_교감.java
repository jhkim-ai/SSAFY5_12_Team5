package com.BaekJoon.StudyEveryWeek;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

/**
 *  Union find 로 확인
 * @author user
 *
 */
public class BJ_1774_우주신과의_교감 {
	static int N, M;
	static int[] parents;
	static Universe[] universe;
	static ArrayList<Universe> list = new ArrayList<>();
	static double answer = 0;
	
	
	public static void main(String[] args) throws IOException {
		BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder output = new StringBuilder();
		StringTokenizer tokens;
		
		input = new BufferedReader(new StringReader(src));

		
		//첫째 줄에 우주신들의 개수(N<=1,000) 이미 연결된 신들과의 통로의 개수(M<=1,000)가 주어진다.
		tokens = new StringTokenizer(input.readLine());
		
		N = Integer.parseInt(tokens.nextToken()); //우주신들의
		M = Integer.parseInt(tokens.nextToken());
		
		parents = new int[N];
		universe = new Universe[N];
		
		
		//부모 초기화
		for(int i = 0; i< N; i++) {
			parents[i] =i;
		}
		
		
		for(int i = 0; i < N; i++) {
			tokens = new StringTokenizer(input.readLine());
			
			int x = Integer.parseInt(tokens.nextToken());
			int y = Integer.parseInt(tokens.nextToken());
			
			universe[i] = new Universe(x, y, 0);
			
		}
		
		for(int i = 0; i < M; i++) {
			tokens = new StringTokenizer(input.readLine());
			
			int uni1 = Integer.parseInt(tokens.nextToken());
			int uni2 = Integer.parseInt(tokens.nextToken());
			
			union(uni1-1, uni2-1);
			
		}
		
		
		//=====================입력부
		
		
		//초기화
		for(int i = 0; i< universe.length-1; i++) {
			Universe uni1 = universe[i];
			for(int j = i+1; j<universe.length; j++) {
				Universe uni2 = universe[j];
				double weight = Math.sqrt(Math.pow(uni1.x - uni2.x, 2) + Math.pow(uni1.y - uni2.y, 2));
				list.add(new Universe(i, j, weight));
			}
		}
		
		//정렬
		Collections.sort(list);
		
		for(int i = 0; i < list.size(); i++) {
			Universe uni = list.get(i);
			if(!isParent(uni.x, uni.y)) {
				answer += uni.weight;
				union(uni.x, uni.y);
			}
		}
		
		System.out.println(String.format("%.2f", answer));
		
	}
	private static class Universe implements Comparable<Universe>{
		int x;
		int y;
		double weight;
		
		
		public Universe(int x, int y, double weight) {
			super();
			this.x = x;
			this.y = y;
			this.weight = weight;
		}


		@Override
		public String toString() {
			return "Universe [x=" + x + ", y=" + y + ", weight=" + weight + "]";
		}


		@Override
		public int compareTo(Universe o) {
			if(this.weight > o.weight) return 1;
			return -1;
		}
		
		
	}
	
	private static int find(int x) {
		if(parents[x] == x) return x;
		return parents[x] = find(parents[x]);
	}
	
	private static void union(int x, int y) {
		x = find(x);
		y = find(y);
		if(x < y) parents[y] = x;
		else parents[x] = y;
	}
	
	private static boolean isParent(int x, int y) {
		return find(x) == find(y);
	}
	static String src="4 1\r\n" + 
			"1 1\r\n" + 
			"3 1\r\n" + 
			"2 3\r\n" + 
			"4 3\r\n" + 
			"1 4";
}
