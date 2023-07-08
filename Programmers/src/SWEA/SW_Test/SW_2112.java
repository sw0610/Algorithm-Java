package SWEA.SW_Test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class SW_2112 {

	static int D, W, K, S, res;
	static int[][] film;
	static int[][] copy;
	static boolean selected[];
	static boolean[] isA;
	static ArrayList<Integer> selectedFilm;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();

		int T = Integer.parseInt(br.readLine());
	
		for (int tc = 1; tc <= T; tc++) {
			st = new StringTokenizer(br.readLine());
			
			D = Integer.parseInt(st.nextToken());
			W = Integer.parseInt(st.nextToken());
			K = Integer.parseInt(st.nextToken());
			
			film = new int[D][W];
			copy = new int[D][W];
			
			for(int i=0;i<D;i++) {
				st = new StringTokenizer(br.readLine());
				for(int j=0;j<W;j++) {
					film[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			
			selected = new boolean[D];
			res=Integer.MAX_VALUE;
			find(0,0);
			sb.append("#"+tc+" "+res+"\n");
			
		}
		System.out.println(sb);

	}
	
	// 부분집합으로 정해주고
	// 그 부분집합을 부분집합으로 나눠야 함 A인지 B인지
	// 합격기준 체크하기
	// 만약 한 줄이라도 통과 못하는 곳이 있다면 넘어가기
	
	//부분집합
	private static void find(int idx, int cnt) {
		if(res!=Integer.MAX_VALUE && cnt>res) {
			return; // 백트래킹
		}
		
		if(idx==D) {
			selectedFilm=new ArrayList<>();
			for(int i=0;i<D;i++) {
				if(selected[i]) {
					selectedFilm.add(i); // 선택된 필름들
				}
			}
			S = selectedFilm.size(); // 선택된 필름의 갯수
			isA = new boolean[S]; // A B 각각 구분해주기 위해 

			selectA(0); // A B 부분집합으로 정해주기

			return;
		}
		
		
		selected[idx]=true;
		find(idx+1, cnt+1);
		selected[idx]=false;
		find(idx+1, cnt);
	}
		
	//A B 정해주기 
	private static void selectA(int idx) {
		if(idx==S) {
			if(check()) {
				res=S;
				return;
			}
			else {
				return;
			}
		}
		
		isA[idx]=true;
		selectA(idx+1);
		isA[idx]=false;
		selectA(idx+1);
	}
	
	// 선택된 것들을 A B로 각각 바꾸고 체크하기
	private static boolean check() {
		for(int i=0;i<D;i++) {
			for(int j=0;j<W;j++) {
				copy[i][j]=film[i][j]; // 배열 복사
			}
		}
		
		// 바꾸기
		for(int i=0;i<S;i++) { // 선택된 막들 중에서
			int x = selectedFilm.get(i);
			if(isA[i]) { // A로 선택되었다면
				for(int k=0;k<W;k++) {
					copy[x][k]=0;
				}
			}
			else { //B로 선택됨
				for(int k=0;k<W;k++) {
					copy[x][k]=1;
				}
			}
		}
		if(test()) {
			return true;
		}else {
			return false;
		}
	}
	
	//성능 검사
	private static boolean test() {
		for(int i=0;i<W;i++) {
			boolean flag=false;
			int cnt = 1;
			for(int j=1;j<D;j++) {
				if(copy[j][i]==copy[j-1][i]) {
					cnt++;
				}else {
					cnt=1;
				}
				if(cnt==K) {
					flag=true;
					break;
				}
			}
			if(!flag) {
				return false;
			}
		}
		return true;
	}
}
