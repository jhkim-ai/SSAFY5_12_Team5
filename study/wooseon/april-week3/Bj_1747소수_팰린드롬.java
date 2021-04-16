package baeckjoon;

import java.util.*;
import java.io.*;

public class Bj_1747소수_팰린드롬 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n=Integer.parseInt(br.readLine());
		
		
		for(int i=n;;i++) {
			if(isPrime(i)&&isP(i)) { //소수면서
				System.out.println(i);
				break;
			}
		}
	}
	
	static boolean isPrime(int x) {
		if(x==1) return false;
		
		int sqrt=(int)Math.sqrt(x);
		for(int i=2;i<=sqrt;i++) {
			if(x%i==0) return false;
		}
		return true;
	}
	
	static boolean isP(int x) {
		String str="";
		int origin=x;
		
		while(x!=0) {
			str+=x%10;
			x/=10;
		}
		
		String str1=Integer.toString(origin);
		if(str1.equals(str)) return true;
		else return false;
	
	}

}

