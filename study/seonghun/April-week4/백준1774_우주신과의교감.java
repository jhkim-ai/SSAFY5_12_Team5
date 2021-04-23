import java.awt.Point;
import java.io.*;
import java.util.*;

class Edge implements Comparable<Edge>{
	int a;
	int b;
	double dist;
	
	public Edge(int a, int b, double dist) {
		super();
		this.a = a;
		this.b = b;
		this.dist = dist;
	}
	
	public int compareTo(Edge o) {
		return Double.compare(dist, o.dist);
	}
}

public class 백준1774_우주신과의교감 {

	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder sb = new StringBuilder();

	static int N,M;
	static Point[] coor;
	static int[] parent;
	static int cnt;
	static double answer = 0;
	public static void main(String[] args) throws Exception {
		input();
	
		List<Edge> list = new ArrayList<Edge>();
		for(int i=1;i<=N;++i) {
			for(int j=i+1;j<=N;++j) {
				if(i==j) continue;
				list.add(new Edge(i,j,getDistance(i, j)));
			}
		}

		Collections.sort(list);
				
		for(Edge e : list) {		
			if(unionGroup(e.a, e.b)) {
				answer+=e.dist;
				if(++cnt==N-1) break;
			}
		}
		
		System.out.printf("%.2f",answer);
	}
	
	private static void input() throws Exception {
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		coor = new Point[N+1];
		parent = new int[N+1];

		for(int i=1;i<=N;++i) {
			st = new StringTokenizer(br.readLine());
			coor[i] = new Point(Integer.parseInt(st.nextToken()),Integer.parseInt(st.nextToken()));
			parent[i] = i;
		}
		
		
		for(int i=0;i<M;++i) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			
			if(unionGroup(a,b)) {
				cnt++;
			}
		}
		
	}

	private static double getDistance(int a, int b) {
		Point A = coor[a];
		Point B = coor[b];
		return Math.sqrt( Math.pow(Math.abs(A.x-B.x),2)+ Math.pow(Math.abs(A.y-B.y),2));
	}
	
	private static boolean unionGroup(int a, int b) {
		int aP = findParent(a);
		int bP = findParent(b);
		
		if(aP!=bP) {
			if(aP>bP) {
				int temp = bP;
				bP = aP;
				aP = temp;
			}
			
			parent[bP] = aP;
			return true;
		}
		
		return false;
	}
	
	private static int findParent(int idx) {
		if(parent[idx]==idx) return idx;
		return parent[idx]=findParent(findParent(parent[idx]));
	}

}
