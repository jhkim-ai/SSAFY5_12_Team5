package baeckjoon;

import java.util.*;
import java.io.*;

public class Bj_1774우주신과의교감 {

	static int n,m;
	ArrayList<int[]>list=new ArrayList<>();
	static int[] parents;
	static Edge[] edge;
	static Vertex[] v;
	static boolean[] visit;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		n=Integer.parseInt(st.nextToken());
		m=Integer.parseInt(st.nextToken());
		parents=new int[n+1];
		v=new Vertex[n+1];
		visit=new boolean[n+1];
		
		
		for(int i=1;i<=n;i++) {
			st=new StringTokenizer(br.readLine());
			int a=Integer.parseInt(st.nextToken());
			int b=Integer.parseInt(st.nextToken());
			v[i]=new Vertex(a,b);
		}
		
		make();
		edge=new Edge[n*(n-1)/2+1];
		
		int idx=1;
		edge[0]=new Edge(0,0,Integer.MAX_VALUE);
		for(int i=1;i<=n;i++) {
			for(int j=i+1;j<=n;j++) {
				//edge.add(new Edge(i,j,length(v[i].x,v[i].y,v[j].x,v[j].y)));
				//edge[j]=(new Edge(j,i,length(v[j].x,v[j].y,v[i].x,v[i].y)));
				edge[idx++]=new Edge(i,j,length(v[i].x,v[i].y,v[j].x,v[j].y));
			}
		}
		
		Arrays.sort(edge);
		
		//Collections.sort(edge);
		
		for(int i=1;i<=m;i++) {
			st=new StringTokenizer(br.readLine());
			
			int s=Integer.parseInt(st.nextToken());
			int e=Integer.parseInt(st.nextToken());
			visit[s]=visit[e]=true;
			
			union(s,e);
		}
		
		
		double result=0;
		int count=0;
		for(Edge e:edge) {
			if(union(e.from,e.to)) {
				result+=e.weight;
				if(++count==n-1) break;
			}
		}
		
	
		System.out.printf("%.2f", result);
		
	}
	
	
	//0부터 차 있어야 비교가 가능하다 아니면 null point 오류 발생
	static class Edge implements Comparable<Edge>{
		int from;
		int to;
		double weight;
		
		Edge(int from,int to,double weight) {
			this.from=from;
			this.to=to;
			this.weight=weight;
		}

		@Override
		public int compareTo(Edge o) {
			return Double.compare(this.weight, o.weight);
		}
		
	}
	
	static class Vertex{
		int x;
		int y;
		
		
		Vertex(int x,int y){
			this.x=x;
			this.y=y;
			
		}
	}
	
	static double length(int r,int c,int r1,int c1) {
		return Math.sqrt(Math.pow(r-r1, 2)+Math.pow(c-c1, 2));
	}
	
	static void make() {
		for(int i=1;i<=n;i++) {
			parents[i]=i;
		}
	}
	
	static int findSet(int a) {
		if(parents[a]==a) return a;
		
		return parents[a]=findSet(parents[a]);
	}

	static boolean union(int a,int b) {
		int aRoot=findSet(a);
		int bRoot=findSet(b);
		if(aRoot==bRoot) return false;
		
		parents[bRoot]=aRoot;
		return true;
	}
	
}
