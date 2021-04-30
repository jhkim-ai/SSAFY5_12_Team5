import java.io.*;
import java.util.*;
public class 백준_12904_A와B {

	/**
	  *@since 2021. 4. 29.
	  *@author skyworking
	  *@see
	  *@time 오전 12:55:03
	  *@caution
	  */
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder sb = new StringBuilder();
	static String S,T;
	public static void main(String[] args) throws Exception{
		S = br.readLine();
		T = br.readLine();

		
		//B빼고 뒤집기,
		//A삭제하기
		
		System.out.println(bfs());
	}
	private static int bfs() {
		Queue<StringBuilder> q = new LinkedList<StringBuilder>();
		q.add(new StringBuilder(T));
		
		int leng = T.length();
		while(!q.isEmpty() && leng>=S.length()) {
			int s = q.size();
			
			for(int i=0;i<s;++i) {				
				StringBuilder str = q.poll();
				
				if(str.toString().equals(S)) return 1;
				
				
				if(str.charAt(leng-1)=='A') {
					StringBuilder cpyStr = new StringBuilder(str.toString());
					cpyStr.setLength(leng-1);
					//System.out.println(cpyStr.toString());
					q.add(cpyStr);
				}
				
				if(str.charAt(leng-1)=='B') {
					StringBuilder revStr = new StringBuilder(str.toString());
					revStr.setLength(leng-1);
					revStr.reverse();
				//	System.out.println(revStr.toString());
					q.add(revStr);
				}

			}
			leng--;
		}
		
		return 0;
	}

}
