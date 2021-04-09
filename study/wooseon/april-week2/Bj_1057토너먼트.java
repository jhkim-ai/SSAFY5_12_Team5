package baeckjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * @since 2021. 4. 6.
 * @author 최우선
 * @see
 * @mem
 * @time
 * @caution Math.ceil을 정확히 사용하려면 double값으로 
 */

public class Bj_1057토너먼트 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int n=Integer.parseInt(st.nextToken());
		double kim=Integer.parseInt(st.nextToken());
		double lim=Integer.parseInt(st.nextToken());
		

		
		int round=1;
		while(true) {
			if((int)Math.ceil(lim/2)==(int)Math.ceil(kim/2)) {
				System.out.println(round);
				break;
			}	
		
			kim=(int)Math.ceil(kim/2);
			lim=(int)Math.ceil(lim/2);
			round++;
		}

	}

}
