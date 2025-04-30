package 프로그래머스.Lv3;

import java.util.HashSet;

public class 풍선터트리기 {
	public static void main(String[] args) {
		int[] a = { -16, 27, 65, -2, 58, -92, -71, -68, -61, -33 };
		System.out.println(solution(a));
	}

	static public int solution(int[] a) {
		int answer = 0;
		HashSet<Integer> hash = new HashSet<>();
		int[] min = { a[0], a[a.length - 1] }; // 왼쪽에서 최솟값, 오른쪽에서 최솟값
		for (int i = 0; i < a.length; i++) {
			if (a[i] < min[0]) {
				min[0] = a[i];
			}
			if (a[a.length - 1 - i] < min[1]) {
				min[1] = a[a.length - 1 - i];
			}
			hash.add(min[0]);
			hash.add(min[1]);
		}
		answer = hash.size();
		return answer;
	}

	static public int solution2(int[] a) {
		int answer = 0;
		int[][] min_num = new int[2][a.length]; // 0번 배열: 왼쪽에 남은 풍선 숫자, 1번 배열: 오른쪽에 남은 풍선 숫자
		min_num[0][0] = a[0];
		min_num[1][a.length - 1] = a[a.length - 1];
		for (int i = 1; i < a.length; i++) { // 큰 숫자만 터트리면서 남을 수 있는 숫자 저장
			if (min_num[0][i - 1] < a[i]) {
				min_num[0][i] = min_num[0][i - 1];
			} else {
				min_num[0][i] = a[i];
			}

			if (min_num[1][a.length - i] < a[a.length - 1 - i]) {
				min_num[1][a.length - 1 - i] = min_num[1][a.length - i];
			} else {
				min_num[1][a.length - 1 - i] = a[a.length - 1 - i];
			}
		}

		for (int i = 0; i < a.length; i++) {
			if (a[i] <= min_num[0][i] || a[i] <= min_num[1][i]) { // 둘 중 하나는 나보다 커야함
				answer += 1;
			}
		}
		return answer;
	}
}
