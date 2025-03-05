package 프로그래머스.Lv3;

import java.util.Arrays;
import java.util.Comparator;

public class 단속카메라 {
	public static void main(String[] args) {
		int[][] routes = { { -20, -15 }, { -14, -5 }, { -18, -13 }, { -5, -3 } };
		System.out.println(solution(routes));
	}

	static public int solution(int[][] routes) {
		int answer = 0;
		Arrays.sort(routes, new MySort()); // 구간 오른차순 정렬
		int cctv = Integer.MIN_VALUE;
		for (int i = 0; i < routes.length; i++) {
			if (cctv < routes[i][0]) { // 현재 구간이 단속카메라를 지나치지 않으면
				answer += 1; // 새로 설치
				cctv = routes[i][1];
			} else { // 겹치는 구간에서 cctv 설치 위치
				cctv = Math.min(routes[i][1], cctv);
			}
		}
		return answer;
	}

	static class MySort implements Comparator<int[]> { // 오른차순 정렬

		@Override
		public int compare(int[] o1, int[] o2) {
			// TODO Auto-generated method stub
			if (o1[0] == o2[0]) {
				return o1[1] - o2[1];
			}
			return o1[0] - o2[0];
		}

	}
}
