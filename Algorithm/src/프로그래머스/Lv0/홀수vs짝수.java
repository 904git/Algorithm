package 프로그래머스.Lv0;

public class 홀수vs짝수 {
	public static void main(String[] args) {
		int[] num_list = { 4, 2, 6, 1, 7, 6 };
		System.out.println(solution(num_list));
	}

	static public int solution(int[] num_list) {
		int answer = 0;
		int[] sum = { 0, 0 };
		for (int i = 0; i < num_list.length; i++) {
			sum[i % 2] += num_list[i]; // 홀수 인덱스, 짝수 인덱스 끼리 합
		}
		answer = Math.max(sum[0], sum[1]);
		return answer;
	}
}
