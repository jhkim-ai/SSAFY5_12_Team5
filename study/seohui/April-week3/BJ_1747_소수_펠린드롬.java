package com.BaekJoon.StudyEveryWeek;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BJ_1747_소수_펠린드롬 {
	static boolean [] list = new boolean[1000000];
	
	static StringBuilder output = new StringBuilder();
	static StringTokenizer tokens;
	static int N;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
		
		input = new BufferedReader(new StringReader(src));
		
		N = Integer.parseInt(input.readLine());
		check();
//		
//		int e = list.length-1;
//		int result = 0; 
//		for(int i = N; i<= e; i++) {
//			if(i==1) {
//				result = 2;
//				System.exit(0);
//				
//			}else {
//				if(check_p(i)&& !list[i]) {
//					result = i;
//					break;
//				}
//			}
//		}
//		System.out.println(result);
//		
//		
//		
//		
//		
//		
		
		
		
		int e = list.length-1;
        if (N == 1){
            System.out.println(2);
            System.exit(0);
        }
        else { for (int i = N;  ; i++){
            if (check_p(i) && isPrime(i)){
                System.out.println(i);
                System.exit(0);
            }
        }}
	}
	static boolean check_p(int num) {
		String s = Integer.toString(num);
//		
//		int start = 0;
//		int end = s.length()-1;
//		
//		while(start <= end) {
//			if(s.charAt(start) != s.charAt(end)) {
//				return false;
//			}
//			start++;
//			end--;
//			
//		}
//		return true;
		int cnt = s.length();
        for (int i = 0; i <= cnt / 2; i++){
            if (s.charAt(i) != s.charAt(cnt-i-1)){
                return false;
            }
        }
        return true;
    }

	static void check() {
		int l = list.length-1;
		
		list[0] = list[1] = false;
		for(int a=0; a<=l; a++) {
			list[a] = true;
		}
		for(int i = 2; i <= l; i++) {
				for(int j = i; j <=l; j+=i) {
					list[j] = false; // false 는  해당 인덱스 소수 아님
					//if(list[j] == false)System.out.println(j);
				}

		}
		
		
	}
    public static boolean isPrime(int x){
        for (int i = 2; i <= Math.sqrt(x); i++){
            if (x % i == 0){
                return false;
            }
        }
        return true;
    }
	
static String src="31";
}
