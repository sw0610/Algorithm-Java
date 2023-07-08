package SWEA.SW_Test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class SW_2382 {

	private static class Microbe {

		int mx, my, cnt, dir, num;

		public Microbe(int mx, int my, int cnt, int dir, int num) {
			this.mx = mx;
			this.my = my;
			this.cnt = cnt;
			this.dir = dir;
			this.num = num;
		}

	}

	static int N, M, K;
//	static int[][] map;
	static ArrayList<Microbe> mInfo;
	static int[] dx = { -1, 1, 0, 0 };
	static int[] dy = { 0, 0, -1, 1 };
	static ArrayList<Integer>[][] pos;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();

		int T = Integer.parseInt(br.readLine());

		for (int tc = 1; tc <= T; tc++) {
			st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			M = Integer.parseInt(st.nextToken());
			K = Integer.parseInt(st.nextToken());

			mInfo = new ArrayList<>(); // 미생물의 정보를 저장할 arr
			pos = new ArrayList[N][N]; // 각 위치마다 미생물 군집이 몇 개 있는지 확인하기 위한 map

			for(int i=0;i<N;i++) {
				for(int j=0;j<N;j++) {
					pos[i][j]=new ArrayList<Integer>();
				}
			}
			for (int i = 0; i < K; i++) {
				st = new StringTokenizer(br.readLine());

				int mx = Integer.parseInt(st.nextToken());
				int my = Integer.parseInt(st.nextToken());
				int cnt = Integer.parseInt(st.nextToken());
				int dir = Integer.parseInt(st.nextToken());

				mInfo.add(new Microbe(mx, my, cnt, dir, i));
//				pos[mx][my].add(i); // 미생물의 번호를 위치에 저장
			}
			
			move();
			int res =0;
			for(int i=0;i<mInfo.size();i++) {
				res+=mInfo.get(i).cnt;
			}
			
			sb.append("#"+tc+" "+res+"\n");
		}
		System.out.println(sb);

	}

	private static void move() {
		for(int t=0;t<M;t++) {
			for(int i=0;i<N;i++) {
				for(int j=0;j<N;j++) {
					pos[i][j]=new ArrayList<Integer>();
				}
			}
			for(int i=mInfo.size()-1;i>=0;i--) {
				Microbe mic = mInfo.get(i); // 현재 확인하는 미생물
//				
//				for(int p=0;p<pos[mic.mx][mic.my].size();p++) { // 이전 위치
//					if(pos[mic.mx][mic.my].get(p)==mic.num) {
//						pos[mic.mx][mic.my].remove(p); // 이전위치에서 빼기
//						break;
//					}
//				}
				
				
				// 이동하기
				mic.mx += dx[mic.dir-1]; 
				mic.my += dy[mic.dir-1];
				
				pos[mic.mx][mic.my].add(mic.num);//새로운 위치로 추가
				
				if(mic.mx==0 ||mic.mx==N-1||mic.my==0 ||mic.my==N-1) {
					mic.cnt = mic.cnt/2; // 미생물 수 반절로 줄이고
					
					if(mic.cnt==0) { //0이면 사라짐
						mInfo.remove(i);
						continue;
					}
					
					int d = mic.dir; // 방향 바꾸기
					
					if(d==1) {
						mic.dir = 2;
					}else if(d==2) {
						mic.dir = 1;
					}else if(d==3) {
						mic.dir = 4;
					}else if(d==4) {
						mic.dir = 3;
					}
					
					
				}
				
			}
			
			// 두 개 이상 겹친 곳 
			for(int p=0;p<N;p++) {
				for(int q=0;q<N;q++) {
					
					if(pos[p][q].size()>=2) { // 한 곳에 두 개 이상 있으면
						int nCnt = 0; 
						int max = Integer.MIN_VALUE;
						int nNum = 0;
						
						for(int z =0;z<pos[p][q].size();z++) { // 그 위치 내에서
							int idx=0;
							for(int w=0;w<mInfo.size();w++) {// 군집 번호 찾기
								if(mInfo.get(w).num==pos[p][q].get(z)) {
									idx = w;
									break;
								}
							}
							
							int c = mInfo.get(idx).cnt;
							nCnt+=c; // 미생물 수 더하기
							if(max<c) { // 최댓값을 가진 미생물 찾기
								max = c;
								nNum = pos[p][q].get(z);
							}
						}
						
						for (int z = pos[p][q].size()-1; z >=0 ; z--) {
							int idx=0;
							for(int w=0;w<mInfo.size();w++) { //번호 찾기
								if(mInfo.get(w).num==pos[p][q].get(z)) {
									idx = w;
									break;
								}
							}
							if (mInfo.get(idx).num == nNum) {
								mInfo.get(idx).cnt = nCnt; //합쳐짐
							}
							else {
								mInfo.remove(idx);
//								pos[p][q].remove(z);
//								z--;
							}
						}
						
					}
				}
			}
		}

	}

}
