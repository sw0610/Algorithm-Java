package Silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class S2_1927 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int N=Integer.parseInt(br.readLine());
		PriorityQueue<Integer> q= new PriorityQueue<Integer>();
		for(int i=0;i<N;i++) {
			int x=Integer.parseInt(br.readLine());
			if(x==0) {
				if(q.isEmpty())
					System.out.println(0);
				else
					System.out.println(q.poll());
					
			}
			else {				
				q.offer(x);
			}
		}
	}
}
