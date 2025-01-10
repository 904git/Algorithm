package 프로그래머스.Lv0;

public class 조건에맞게수열변환하기2 {
	public static void main(String[] args) {
		int[] arr = { 1, 2, 3, 100, 99, 98 };
		System.out.println(solution(arr));
	}

	static public int solution(int[] arr) {
		int answer = 0;
		for (int i = 0; i < arr.length; i++) {
			int cnt = 0; // 연산 횟수
			int pre = 0; // arr(x)
			int next = arr[i]; // arr(x+1)
			while (pre != next) { // arr(x)와 arr(x+1)이 같아질 때까지
				cnt += 1;
				pre = next;
				if (50 <= next && next % 2 == 0) {
					next = next / 2;
				} else if (next < 50 && next % 2 != 0) {
					next = next * 2 + 1;
				}
			}
			answer = Math.max(answer, cnt - 1);
		}
		return answer;
	}
}
