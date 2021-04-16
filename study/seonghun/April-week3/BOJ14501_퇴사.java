#include <iostream>
#include <vector>
#include <algorithm>


using namespace std;
//6:48

struct info {
	int period;
	int price;

};

int answer = 0;
vector<info> v;
int visit[1001] = { 0, };
int N;

void dfs(int idx,int total) {
	if (idx  == v.size()) {
		answer = max(answer, total);
		return;
	}


	//방문할 때
	if (visit[idx] == 0 && idx+v[idx].period <= v.size()) {
		for (int i = 0; i < v[idx].period; i++) {
			visit[idx+i]++;
		}
		dfs(idx + 1, total + v[idx].price);
		for (int i = 0; i < v[idx].period; i++) {
			visit[idx+i]--;
		}
	}
	
	//방문 안할 때
	dfs(idx + 1, total);
}
int main() {
	cin >> N;

	for (int i = 0; i < N; i++) {
		int a, b;
		cin >> a >> b;;

		v.push_back(info{ a,b });
	}

	dfs(0,0);
	//dfs(0, 0,1);
	cout << answer;
	return 0;
}