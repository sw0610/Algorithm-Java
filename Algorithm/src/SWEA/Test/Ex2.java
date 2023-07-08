package SWEA.Test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class Ex2 {
	
	static class Customer implements Comparable<Customer>{
		int num, cx, cy;

		public Customer(int num, int cx, int cy) {
			this.num = num;
			this.cx = cx;
			this.cy = cy;
		}

		@Override
		public int compareTo(Customer o) {
			return this.num-o.num;
		}
		
	}
	
	static class Monster implements Comparable<Monster>{
		int num, mx, my;

		public Monster(int num, int mx, int my) {
			this.num = num;
			this.mx = mx;
			this.my = my;
		}

		@Override
		public int compareTo(Monster o) {
			return o.num-this.num;
		}
		
	}
	static int N, map[][], M, nums[], min, order[];
	static ArrayList<Customer> cust;
	static ArrayList<Monster> mon;
	static boolean selected[];
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();

		int T = Integer.parseInt(br.readLine());
		

		for (int tc = 1; tc <= T; tc++) {
			N = Integer.parseInt(br.readLine());

			map = new int[N][N];
			cust = new ArrayList<>();
			mon = new ArrayList<>();
			M=0;
			for (int i = 0; i < N; i++) {
				st = new StringTokenizer(br.readLine());
				for (int j = 0; j < N; j++) {
					map[i][j] = Integer.parseInt(st.nextToken());
					if (map[i][j] > 0) {
						M++;
						cust.add(new Customer(map[i][j], i, j));
					}
					else if(map[i][j]<0) {
						mon.add(new Monster(map[i][j], i, j));

					}
				}
			}

			nums=new int[M*2];
			order=new int[M*2];
			selected=new boolean[M+1];
			
			Collections.sort(cust);
			Collections.sort(mon);
			
//			for(int i=0;i<cust.size();i++) {
//				System.out.println(cust.get(i).cx+" "+cust.get(i).cy);
//			}

			int x=1;
			for(int i=0;i<M*2;i+=2) {
				order[i]=x;
				order[i+1]=-x;
				x++;
			}
			
			min=Integer.MAX_VALUE;
			perm(0,0);
			sb.append("#"+tc+" "+min+"\n");
		}
		System.out.println(sb);
		
		

	}
	private static void perm(int cnt, int flag) {
		if(cnt==M*2) {
//			System.out.println(Arrays.toString(nums));
			int x=distance();
			min=Math.min(min,x);
//			System.out.println(min);
			return;
		}
		for(int i=0;i<M*2;i++) {
			if((flag&1<<i)!=0) {
				continue;
			}
			if(order[i]<0) {
				if(!selected[-order[i]]) {
					continue;
				}
			}
			nums[cnt]=order[i];
			if(order[i]>0) {
				selected[order[i]]=true;
			}
			perm(cnt+1, flag|1<<i);
			if(order[i]>0) {
				selected[order[i]]=false;
			}
		}
	}
	private static int distance() {
		int d=0;
		
		int nx=0;
		int ny=0;
		
		for(int i=0;i<M*2;i++) {
			if(d>=min) {
				d=Integer.MAX_VALUE;
				break;
			}
//			else {
				int idx=nums[i];
//				System.out.println(idx);
				if(idx>0) {
					Customer c=cust.get(idx-1);
					d+=Math.abs(nx-c.cx)+Math.abs(ny-c.cy);
					nx=c.cx;
					ny=c.cy;
				}
				else {					
					Monster m=mon.get((-idx)-1);
					d+=Math.abs(nx-m.mx)+Math.abs(ny-m.my);
					nx=m.mx;
					ny=m.my;
				}
			
//			}

		}
		
		return d;
	}
}
