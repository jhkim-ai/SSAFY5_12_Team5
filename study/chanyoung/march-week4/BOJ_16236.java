// 16236, 아기 상어 | https://www.acmicpc.net/problem/16236
package BOJ;

import java.io.*;
import java.util.*;

public class BOJ_16236 {

	static int N;
	static int[][] map;
	static int[] dx = { -1, 0, 0, 1 };
	static int[] dy = { 0, -1, 1, 0 };
	static int time = 0; // 몇 초 동안
	static int weight = 0; // 먹은 물고기 수
	static int shark = 2; // 아기상어 크기 초기값

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		map = new int[N][N];
		int sr = -1, sc = -1;
		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			for (int j = 0; j < N; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				if (map[i][j] == 9) {
					sr = i;
					sc = j;
					map[i][j] = 0;
				}
			}
		}
		// 입력 끝

		while (true) {
			int[] temp = bfs(sr, sc);
			if (temp[0] == -1 && temp[1] == -1)	// -1, -1 되면 큐가 끝날 때까지 먹을 물고기를 찾지 못한 것.
				break;
			sr = temp[0];
			sc = temp[1];
		}

		System.out.println(time);
	}

	static int[] bfs(int r, int c) {

		int[][] visited = new int[N][N];
		Queue<Integer[]> q = new LinkedList<Integer[]>();

		q.add(new Integer[] { r, c });
		visited[r][c] = 1;
		
		int time_cnt = 0;
		while (!q.isEmpty()) {
			
			int size = q.size();	// 같은 depth에 있는 칸들만 확인하기 위해
			int r_min = Integer.MAX_VALUE;
			int c_min = Integer.MAX_VALUE;
			
			for (int s = 0; s < size; s++) {
				Integer[] now = q.poll();
				int now_x = now[0];
				int now_y = now[1];
				for (int i = 0; i < 4; i++) {
					int nx = now_x + dx[i];
					int ny = now_y + dy[i];

					if (!isIn(nx, ny) || visited[nx][ny] != 0)
						continue;

					// 물고기가 없거나, 상어의 크기보다 작거나 같다면 지나갈 수 있다.
					if (visited[nx][ny] == 0 && (map[nx][ny] == 0 || map[nx][ny] <= shark)) {
						// 빈 곳이 아니고, 자기보다 작은 물고기면 먹을 수 있다.
						if (map[nx][ny] != 0 && map[nx][ny] < shark) { 
							// 먹을 수 있는 물고기가 많을 때, 가장 위에 있는 물고기
							if (nx<r_min) {	
								r_min = nx;
								c_min = ny;
							} 
							// 그런 물고기가 여러 마리라면 가장 왼쪽에 있는 물고기
							else if(nx==r_min) {
								if (ny<c_min) {
									c_min = ny;
								}
							}
						}
						
						visited[nx][ny] = visited[now_x][now_y] + 1;
						q.offer(new Integer[] { nx, ny }); // 움직일 수 있음 -> 큐에 추가
					}
				}
			}
			
			// 먹은 물고기가 있으면
			if (r_min!=Integer.MAX_VALUE) {
				
				weight++; // 물고기를 먹으면 크기가 1 증가한다.
				
				if (weight == shark) {	 // 자신의 크기와 같은 수의 물고기를 먹으면 
					shark++;	// 크기가 1 증가한다.
					weight = 0; // 물고기 먹은 양 초기화
				}
				
				time += (visited[r_min][c_min]-1);
				map[r_min][c_min] = 0;	// 먹힌 물고기 칸 빈 곳으로 만듦
				
				return new int[] { r_min, c_min };	// 먹은 위치 -> 상어의 새로운 위치
			}
			
		}

		return new int[] { -1, -1 };	// 
	}

	static boolean isIn(int r, int c) {
		return 0 <= r && r < N && 0 <= c && c < N;
	}

}
