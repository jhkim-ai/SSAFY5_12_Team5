package baeckjoon;

import java.util.*;
import java.io.*;


public class Bj_1662압축 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String str=br.readLine();
		Stack<Character> a = new Stack<>(); //괄호 처리
		Stack<Integer> b = new Stack<>(); //길이 관리

		int l=0;
		int size=str.length();
		for(int i=0;i<size;i++) {
			char ch=str.charAt(i);
			if(ch=='(') {
				a.push(ch);
			}else if(ch==')') {
				l=0;
				while(a.peek()!='(') {
					a.pop();
					l+=b.pop();
				}
				a.pop();//'(' 제거
				
				int s=a.pop()-'0';
				b.pop();
				
				a.push('0'); //이거에 맞는 문자열 길이가 b에 들어있음 
				b.push(s*l);
			}
			else { //숫자면
				a.push(ch);
				b.push(1);
			}
		}
		
	
		
		int ans=0;
		while(!b.isEmpty()) {
			ans+=b.pop();
		}
		
		System.out.println(ans);

	}


}
