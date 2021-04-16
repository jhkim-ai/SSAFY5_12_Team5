package baeckjoon;

import java.util.*;
import java.io.*;

// 한 번호에 대해서 무거운 경우, 가벼운경우가 모두 1번이상 나오게 되면 중간 또는 각각의 경우가 두번이상이면 중간이 될 수 없다고 판단  -> 오답
// so, 그래프 개념 이용

public class Bj_2617구슬찾기 {
	
	static ArrayList<Integer>[] h;
	static ArrayList<Integer>[] l;

	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n=Integer.parseInt(st.nextToken());
		int m=Integer.parseInt(st.nextToken());
		visitl=new boolean[n+1];
		visith=new boolean[n+1];

		int ans=0;
		
		l = new ArrayList[n+1];
		h = new ArrayList[n+1];
		for(int i=1;i<=n;i++) {
			l[i]=new ArrayList<>();
			h[i]=new ArrayList<>();
		}
		
		for(int i=0;i<m;i++) {
			st=new StringTokenizer(br.readLine());
			int heavy=Integer.parseInt(st.nextToken());
			int light=Integer.parseInt(st.nextToken());
			
			h[heavy].add(light);
			l[light].add(heavy);
		}

		
		for(int i=1;i<=n;i++) { //무거운 구슬 판단
			cnt=0;
			visitl=new boolean[n+1];
			if(l[i].size()==0) continue;
			dfsl(i);
			if(cnt>n/2) {
				ans++;
			}
		}
		
		for(int i=1;i<=n;i++) { //무거운 구슬 판단
			cnt=0;
			visith=new boolean[n+1];
			if(h[i].size()==0) continue;
			dfsh(i);
			if(cnt>n/2) {
				ans++;
			}
		}
		
		
		System.out.println(ans);
		
	}
	
	static boolean[] visitl;
	static boolean[] visith;
	static int cnt=0;
	
	static void dfsl(int x) {
		visitl[x]=true;
		int size=l[x].size();
		if(size==0) {
			return;
		}
		for(int i=0;i<size;i++) {
			if(!visitl[l[x].get(i)]) {
				visitl[l[x].get(i)]=true;
				cnt++;
				dfsl(l[x].get(i));
			}
		}
	}
	
	
	static void dfsh(int x) {
		visith[x]=true;
		int size=h[x].size();
		if(size==0) {
			return;
		}
		for(int i=0;i<size;i++) {
			if(!visith[h[x].get(i)]) {
				
				cnt++;
				visith[h[x].get(i)]=true;
				dfsh(h[x].get(i));
			}
		}
	}
		

}
