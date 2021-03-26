package BOJ.Gold;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

public class B16236_아기상어 {
	static int[][] map, visit, deltas= {{-1, 0}, {1, 0}, {0, -1}, {0, 1}}; // 상 하 좌 우
	static int N, cnt, totalCnt, sharkS, time, ans, count, sizeC;
	static Queue<shark> queue;
	static PriorityQueue<shark> fish;
	static class shark implements Comparable<shark>{
		int r, c, size;

		public shark(int r, int c) {
			super();
			this.r = r;
			this.c = c;
		}
		
		@Override
		public int compareTo(shark o) {
			if (this.r==o.r) {
				count++;
			}
			if (count == 0)return this.r-o.r;
			else {
				count = 0;
				return this.c-o.c;
			}
		}
		
	}
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		map = new int[N][N];
		visit = new int[N][N];
		queue = new LinkedList<>();
		fish = new PriorityQueue<>();
		sharkS = 2;
		for (int r=0;r<N;r++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int c=0;c<N;c++) {
				map[r][c] = Integer.parseInt(st.nextToken());
				if (map[r][c]==9) {
					queue.offer(new shark(r, c));
					map[r][c]=0;
				}
			}
		}
		// 입력완료
		bfs();
		if (totalCnt==0) System.out.println(0);
		else System.out.println(ans);
	}
	
	static void bfs() {
		while(!queue.isEmpty()) {
			time++;
			int size = queue.size();
			cnt = 0;
			for (int i=0;i<size;i++) {
				shark now = queue.poll();
				visit[now.r][now.c] = 1; 
				for (int d=0;d<4;d++) {
					int nr = now.r+deltas[d][0];
					int nc = now.c+deltas[d][1];
					if (isIn(nr, nc) && map[nr][nc]<=sharkS && visit[nr][nc]==0) {
						if (map[nr][nc]>0 && map[nr][nc]<sharkS) {
							cnt++; // 현재 먹은 물고기 개수
							fish.offer(new shark(nr, nc));
						} else queue.offer(new shark(nr, nc));
						visit[nr][nc] = 1;
					}
				}
			}
			if (cnt>0) {
				totalCnt++;
				ans += time;
				time = 0;
				sizeC++; // 현재까지 먹은 물고기 개수
				if (sizeC==sharkS) {
					sharkS++; // 아기상어 크기와 먹은 물고기 개수가 같으면 크기 1 증가
					sizeC = 0;
				}
				shark save = fish.poll();
				map[save.r][save.c] = 0;
				queue = new LinkedList<>();
				queue.offer(save);
				fish = new PriorityQueue<>();
				visit = new int[N][N];
			}
		}
	}
	
	static boolean isIn(int nr, int nc) {
		return nr>=0 && nr<N && nc>=0 && nc<N;
	}
}
