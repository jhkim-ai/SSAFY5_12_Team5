import java.io.*;
import java.util.*;

public class Main {

	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder sb = new StringBuilder();
	static int N;
	static int[] arr;
	static int M;
	static int total;
	public static void main(String[] args) throws Exception {
		 N= Integer.parseInt(br.readLine());
		 arr= new int[N];
		 StringTokenizer st= new StringTokenizer(br.readLine()," ");
		 
		 int MAX = 0;
		 for(int i=0;i<N;++i) {
			 arr[i] = Integer.parseInt(st.nextToken());
			 MAX = Math.max(arr[i],MAX);
			 total+=arr[i];
		 }
		 
		 M = Integer.parseInt(br.readLine());
		 
		 
		 int lo = 0;
		 int hi = MAX;
		 int answer = 0;
		 while(lo<=hi) {
			 int mid = (lo+hi)/2;
			 int res =0;
			 for(int num : arr) {
				 if(res>M) break;
				 if(num<=mid) res+=num;
				 else res+=mid;
			 }
			 
			 if(res<=M) {
				 answer = mid;
				 lo = mid+1;
			 }else {
				 hi = mid-1;
			 }
		 }
		 
		 System.out.println(answer);
		
	}

}
