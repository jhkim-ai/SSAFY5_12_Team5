package baeckjoon;

import java.util.*;
import java.io.*;

public class Bj_16946벽부수고이동하기4 {

	static int[][] deltas= {{-1,0},{1,0},{0,-1},{0,1}};
	static int n,m;
	static int[][] map;
	static CNT[][] ans;
	static int[] count=new int[500001];
	static int count_size;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		StringBuilder sb = new StringBuilder();
		
		n=Integer.parseInt(st.nextToken());
		m=Integer.parseInt(st.nextToken());
		map=new int[n][m];
		ans=new CNT[n][m];
		visit= new boolean[n][m];
		
		for(int i=0;i<n;i++) {
			String str=br.readLine();
			for(int j=0;j<m;j++) {
				char x=str.charAt(j);
				map[i][j]=x-48;
			}
		}
		
		
		for(int i=0;i<n;i++) {
			for(int j=0;j<m;j++) {
				if(map[i][j]==0&&!visit[i][j]) {
					bfs(i,j);
					count[idx]=cnt;
					ans[i][j]=new CNT(cnt,idx++);
					cnt=1;
				}
				
			}
		}
		
		count_size=idx+1;
		
		//같은 그룹일시, 같은 cnt값을 가지도록
		for(int z=0;z<n;z++) {
			for(int j=0;j<m;j++) {
				if(map[z][j]==0) {
					ans[z][j].cnt=count[ans[z][j].i];
				}
			}
		}
		
		
		for(int z=0;z<n;z++) {
			for(int j=0;j<m;j++) {
				if(map[z][j]==1) {
					int sum=0;
					boolean[] check=new boolean[count_size];
					int tx=z;
					int ty=j;
					
					for(int i=0;i<4;i++) {
						int tr=tx+deltas[i][0];
						int tc=ty+deltas[i][1];
						
						if(isIn(tr,tc)&&map[tr][tc]==0&&!check[ans[tr][tc].i]) {
							check[ans[tr][tc].i]=true;
							sum+=ans[tr][tc].cnt;
						}
						
					}
					sum++;
					map[z][j]=(sum%10);
				}
			}
		}
		
		for(int z=0;z<n;z++) {
			for(int j=0;j<m;j++) {
				if(map[z][j]!=0) {
					sb.append(map[z][j]);
				}
				else {
					sb.append(0);
				}
			}
			sb.append("\n");
		}
		
		System.out.println(sb);

	}
	
	static boolean[][] visit;
	static int cnt=1;
	static int idx=1;
	
	static void bfs(int x,int y) {
		Queue<int[]> q = new LinkedList<>();
		visit[x][y]=true;
		q.add(new int[] {x,y});
		
		while(!q.isEmpty()) {
			int tx=q.peek()[0];
			int ty=q.poll()[1];
			
			for(int i=0;i<4;i++) {
				int tr=tx+deltas[i][0];
				int tc=ty+deltas[i][1];
				
				if(isIn(tr,tc)&&!visit[tr][tc]&&map[tr][tc]==0) {
					visit[tr][tc]=true;
					q.add(new int[] {tr,tc});
					ans[tr][tc]=new CNT(cnt,idx);
					cnt++;
				}
				
			}
		}
		
		
	}
	
	static class CNT {
		int cnt;
		int i;
		
		CNT(int cnt,int i){
			this.cnt=cnt;
			this.i=i;
		}
	}
	
	static boolean isIn(int r,int c) {
		return 0<=r&&r<n&&0<=c&&c<m;
	}

}
