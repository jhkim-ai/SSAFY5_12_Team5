package com.BaekJoon.StudyEveryWeek;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class BJ_16432_떡장수호랑이 {
	static ArrayList[] list;
	static boolean [][] visited;
	static int [] answer;
	static StringBuilder output = new StringBuilder();

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer tokens;
		
		input = new BufferedReader(new StringReader(src));
		int T = Integer.parseInt(input.readLine());
		
		list = new ArrayList[T+1];
		for(int tc = 1; tc<=T; ++tc) {
			list[tc] = new ArrayList<>();
			tokens = new StringTokenizer(input.readLine());
			int n = Integer.parseInt(tokens.nextToken());
			
			for(int i = 0; i <n; ++i) {
				list[tc].add(Integer.parseInt(tokens.nextToken()));
			}
		}
		
		
		  	answer = new int[T+1];
	        visited = new boolean[T+2][10]; //[n번째 날][떡의 종류]
	        dfs(1, 0, T);
	        System.out.println("-1");


	}

	static void dfs(int index, int used_dduck, int toChoose) {
		   if(index == toChoose+1) {
	            for(int i = 1; i < toChoose+1; ++i) {
	                output.append(answer[i]).append("\n");
	            }
	            System.out.println(output);
	            System.exit(0);
	        }
	    
	        for(int i = 1; i < 10; ++i) {
	        	//준 적 없는 떡, 방문한 여부가 없고, 아직 해당 떡이 있을때
	            if(i != used_dduck && visited[index + 1][i] == false && list[index].contains((Integer)i)) {
	                visited[index + 1][i] = true;
	                answer[index] = i;
	                dfs(index + 1, i, toChoose);
	            }
	        }
	}
	static String src="3\r\n" + 
			"3 1 2 3\r\n" + 
			"2 1 2\r\n" + 
			"2 2 3";
}
