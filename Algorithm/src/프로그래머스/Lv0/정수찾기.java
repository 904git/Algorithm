package 프로그래머스.Lv0;

public class 정수찾기 {
	public static void main(String[] args) {
		int[] num_list = { 1, 2, 3, 4, 5 };
		int n = 3;
		System.out.println(solution(num_list, n));
	}

	static public int solution(int[] num_list, int n) {
		int answer = 0;
		for (int i = 0; i < num_list.length; i++) {
			if (num_list[i] == n) { // 배열안에 n이 있으면
				answer = 1;
				break;
			}
		}
		return answer;
	}
}
