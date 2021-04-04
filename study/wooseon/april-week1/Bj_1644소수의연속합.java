package baeckjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class Bj_1644소수의연속합 {

	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n=Integer.parseInt(br.readLine());
		boolean[] num=new boolean[n+1];

		for(int i=2;i<=n;i++) {
			for(int j=i+i;j<=n;j+=i) {
				num[j]=true;
			}
		}
		
		ArrayList<Integer> list=new ArrayList<>();
		for(int i=2;i<=n;i++) {
			if(!num[i]) {list.add(i);
				//System.out.println(i+" ");
			}
		}
		
		int cnt=0;
		int sum=0;
		int size=list.size();
		for(int i=0;i<size;i++) {
			int idx=i;
			while(sum<n) {
				sum+=list.get(idx++);
				if(idx==size) break;
			}
			if(sum==n) cnt++;
			sum=0;
		}
		System.out.println(cnt);
	}

}
